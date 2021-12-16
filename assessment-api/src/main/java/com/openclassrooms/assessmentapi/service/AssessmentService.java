package com.openclassrooms.assessmentapi.service;

import com.openclassrooms.assessmentapi.dto.PatientDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The interface Assessment service.
 */
@Service
public interface AssessmentService {

    /**
     * Gets patient assessment by id.
     *
     * @param patientId the patient id
     * @return the patient assessment by id
     * @throws Exception the exception
     */
    Assessment getPatientAssessmentById(Integer patientId) throws Exception;

    /**
     * Gets all patient by family name.
     *
     * @param familyName the family name
     * @return the all patient by family name
     */
    List<PatientDTO> getAllPatientByFamilyName(String familyName);
}
