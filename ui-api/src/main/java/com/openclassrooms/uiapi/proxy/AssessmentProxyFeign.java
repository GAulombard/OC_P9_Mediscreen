package com.openclassrooms.uiapi.proxy;

import com.openclassrooms.uiapi.dto.AssessmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The interface Assessment proxy feign.
 */
@FeignClient(value = "assessment-api",url="${proxy.assessment}")
public interface AssessmentProxyFeign {

    /**
     * Gets patient assessment.
     *
     * @param patientId the patient id
     * @return the patient assessment
     */
    @GetMapping("/{id}")
    AssessmentDTO getPatientAssessment(@PathVariable("id") Integer patientId);

    /**
     * Gets family assessment.
     *
     * @param familyName the family name
     * @return the family assessment
     */
    @GetMapping("/familyName")
    List<AssessmentDTO> getFamilyAssessment(@RequestParam(value="value") String familyName);

}
