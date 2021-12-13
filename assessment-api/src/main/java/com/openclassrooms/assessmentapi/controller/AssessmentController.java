package com.openclassrooms.assessmentapi.controller;

import com.openclassrooms.assessmentapi.model.Assessment;
import com.openclassrooms.assessmentapi.service.AssessmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment")
@Slf4j
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping("/{id}")
    @ApiOperation(value = "This URI returns the patient id given a note id")
    public Assessment getPatientAssessment(@ApiParam(
            value = "id",
            example = "4"
    )@PathVariable("id") Integer patientId) throws Exception {
        log.info("HTTP GET request received at /assessment/"+patientId);

        Assessment assessment = assessmentService.getPatientAssessmentById(patientId);

        return assessment;
    }

}
