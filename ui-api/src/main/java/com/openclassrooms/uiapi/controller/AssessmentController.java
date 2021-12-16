package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.AssessmentDTO;
import com.openclassrooms.uiapi.proxy.AssessmentProxyFeign;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The type Assessment controller.
 */
@Controller
@Slf4j
@RequestMapping({"/assessment"})
public class AssessmentController {

    @Autowired
    private AssessmentProxyFeign assessmentProxyFeign;

    /**
     * Gets patient assessment.
     *
     * @param patientId the patient id
     * @param model     the model
     * @return the patient assessment
     */
    @ApiOperation(value = "This URI returns the assessment given a patient id")
    @GetMapping({"/{id}"})
    public String getPatientAssessment(@ApiParam(
            value = "id",
            example = "4"
    )@PathVariable("id") Integer patientId, Model model){
        log.info("HTTP GET request received at /assessment/"+patientId);

        AssessmentDTO assessmentDTO = null;

        try {
            assessmentDTO = assessmentProxyFeign.getPatientAssessment(patientId);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        model.addAttribute("assessment",assessmentDTO.toString());

        return "assessment/individual";
    }

    /**
     * Gets family assessment.
     *
     * @param familyName the family name
     * @param model      the model
     * @return the family assessment
     */
    @ApiOperation(value = "This URI returns a list of assessment given a family name")
    @GetMapping({"/familyName"})
    public String getFamilyAssessment(@ApiParam(
            value = "familyName",
            example = "Ferguson"
    )@RequestParam(value="value") String familyName, Model model){
        log.info("HTTP GET request received at /assessment/familyName?value="+familyName);

        List<AssessmentDTO> assessmentDTOList = null;

        try {
            assessmentDTOList = assessmentProxyFeign.getFamilyAssessment(familyName);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        model.addAttribute("assessmentList",assessmentDTOList);

        return "assessment/family";
    }

}
