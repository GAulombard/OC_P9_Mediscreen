package com.openclassrooms.assessmentapi.proxy;

import com.openclassrooms.assessmentapi.dto.PatientDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "patient-api",url="${proxy.patient}")
public interface PatientProxyFeign {

    @GetMapping({"/list"})
    List<PatientDTO> getAll();

    @GetMapping({"/delete/{id}"})
    void delete(@PathVariable("id") Integer id);

    @PostMapping({"/validate"})
    void validate(PatientDTO patientDTO);

    @GetMapping({"/{id}"})
    PatientDTO getPatientById(@PathVariable("id") Integer id);

    @PostMapping({"/update/{id}"})
    void update(@PathVariable("id") Integer id, PatientDTO patientDTO);

    @GetMapping("/list/{familyName}")
    List<PatientDTO> getAllByLastName(@PathVariable("familyName") String familyName);
}
