package com.openclassrooms.assessmentapi.controller;

import com.openclassrooms.assessmentapi.dto.AssessmentDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import com.openclassrooms.assessmentapi.service.AssessmentService;
import com.openclassrooms.assessmentapi.util.DTOConverter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assessment")
@Slf4j
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private DTOConverter dtoConverter;

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

/*    @GetMapping("/{familyName}")
    @ApiOperation(value = "This URI returns a list of assessment given a family name")
    public List<AssessmentDTO> getFamilyAssessment(@ApiParam(
            value = "familyName",
            example = "Family"
    )@PathVariable("familyName") String familyName){
        log.info("HTTP GET request received at /assessment/"+familyName);


        return null;
    }*/

}
