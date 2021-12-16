package com.openclassrooms.assessmentapi.service;

import com.openclassrooms.assessmentapi.dto.NoteDTO;
import com.openclassrooms.assessmentapi.dto.PatientDTO;
import com.openclassrooms.assessmentapi.enumeration.DiabetesTrigger;
import com.openclassrooms.assessmentapi.enumeration.RiskLevel;
import com.openclassrooms.assessmentapi.model.Assessment;
import com.openclassrooms.assessmentapi.proxy.HistoryProxyFeign;
import com.openclassrooms.assessmentapi.proxy.PatientProxyFeign;
import com.openclassrooms.assessmentapi.util.AgeCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * The type Assessment service imp.
 */
@Service
@Slf4j
public class AssessmentServiceImp implements AssessmentService{

    @Autowired
    private PatientProxyFeign patientProxyFeign;

    @Autowired
    private HistoryProxyFeign historyProxyFeign;

    @Autowired
    private AgeCalculator ageCalculator;

    @Override
    public Assessment getPatientAssessmentById(Integer patientId) throws Exception {
        log.info("** Process to get patient assessment by id");

        PatientDTO patientDTO = new PatientDTO();
        List<NoteDTO> noteDTOList = new ArrayList<>();

        try {
            patientDTO = patientProxyFeign.getPatientById(patientId);
            noteDTOList = historyProxyFeign.getAll(patientId);
        } catch (Exception e) {
            log.error(""+e.getMessage());
            throw new Exception(""+e.getMessage());
        }

        int age = ageCalculator.getAgeFromBirthDate(patientDTO.getBirthDate());
        int numberTrigger = getNumberTriggerNote(noteDTOList);
        String riskLevel = getRiskLevel(numberTrigger,age,patientDTO.getSex());

        return new Assessment(patientDTO,riskLevel);
    }

    @Override
    public List<PatientDTO> getAllPatientByFamilyName(String familyName) {
        log.info("** Process to get list of patient by family name");

        return patientProxyFeign.getAllByLastName(familyName);
    }

    private int getNumberTriggerNote(List<NoteDTO> notes) {
        log.info("** Process to get note trigger");

        EnumSet<DiabetesTrigger> diabetesTriggers = EnumSet.allOf(DiabetesTrigger.class);

        List<DiabetesTrigger> patientTriggers = new ArrayList();
        diabetesTriggers.forEach(diabetesTrigger -> {
            notes.forEach(note -> {
                if (StringUtils.containsIgnoreCase(note.getNote(), diabetesTrigger.getTrigger()) &&
                        !patientTriggers.contains(diabetesTrigger)) {
                    patientTriggers.add(diabetesTrigger);
                }
            });
        });

        return patientTriggers.size();
    }

    private String getRiskLevel(int nbrTrigger, int age,String gender) {
        log.info("** Process to get risk level");

        String riskLevel = RiskLevel.NONE.getRiskLevel();

        if ((((gender.equals("F")) && age < 30 && nbrTrigger >= 7) || ((gender.equals("M")) && age < 30
                && nbrTrigger >= 5)) || (age >= 30 && nbrTrigger >= 8)) {
            riskLevel = RiskLevel.EARLY_ONSET.getRiskLevel();
        } else if ((gender.equals("M") && age < 30 && nbrTrigger >= 3) || ((gender.equals("F")) && age < 30
                && nbrTrigger >= 4) || (age >= 30 && nbrTrigger >= 6)) {
            riskLevel = RiskLevel.IN_DANGER.getRiskLevel();
        } else if ((age >= 30 && nbrTrigger >= 2)) {
            riskLevel = RiskLevel.BORDERLINE.getRiskLevel();
        }

        return riskLevel;
    }
}
