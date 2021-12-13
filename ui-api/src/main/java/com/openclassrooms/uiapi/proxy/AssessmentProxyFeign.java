package com.openclassrooms.uiapi.proxy;

import com.openclassrooms.uiapi.dto.AssessmentDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "assessment-api",url="${proxy.assessment}")
public interface AssessmentProxyFeign {

    @GetMapping("/{id}")
    AssessmentDTO getPatientAssessment(@PathVariable("id") Integer patientId);

    @GetMapping("/{familyName}")
    List<AssessmentDTO> getFamilyAssessment(@PathVariable("familyName") String familyName);

}
