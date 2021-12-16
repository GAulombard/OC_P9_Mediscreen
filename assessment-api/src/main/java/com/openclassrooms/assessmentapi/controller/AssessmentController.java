package com.openclassrooms.assessmentapi.controller;

import com.openclassrooms.assessmentapi.dto.AssessmentDTO;
import com.openclassrooms.assessmentapi.dto.PatientDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import com.openclassrooms.assessmentapi.service.AssessmentService;
import com.openclassrooms.assessmentapi.util.DTOConverter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assessment controller.
 */
@RestController
@RequestMapping("/assessment")
@Slf4j
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private DTOConverter dtoConverter;

    /**
     * Gets patient assessment.
     *
     * @param patientId the patient id
     * @return the patient assessment
     * @throws Exception the exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "This URI returns the assessment given a patient id")
    public AssessmentDTO getPatientAssessment(@ApiParam(
            value = "id",
            example = "4"
    )@PathVariable("id") Integer patientId) throws Exception {
        log.info("HTTP GET request received at /assessment/"+patientId);

        Assessment assessment = assessmentService.getPatientAssessmentById(patientId);

        return dtoConverter.AssessmentToAssessmentDTO(assessment);
    }

    /**
     * Gets family assessment list.
     *
     * @param familyName the family name
     * @return the family assessment list
     */
    @GetMapping("/familyName")
    @ApiOperation(value = "This URI returns a list of assessment given a family name")
    public List<AssessmentDTO> getFamilyAssessmentList(@ApiParam(
            value = "familyName",
            example = "Ferguson"
    )@RequestParam(value="value") String familyName){
        log.info("HTTP GET request received at /assessment/familyName?value="+familyName);

        List<AssessmentDTO> assessmentDTOList = new ArrayList<>();
        List<PatientDTO> patientDTOList = assessmentService.getAllPatientByFamilyName(familyName);

        patientDTOList.forEach(patientDTO -> {
            try {
                assessmentDTOList.add(dtoConverter.AssessmentToAssessmentDTO(assessmentService.getPatientAssessmentById(patientDTO.getId())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return assessmentDTOList;
    }

}
