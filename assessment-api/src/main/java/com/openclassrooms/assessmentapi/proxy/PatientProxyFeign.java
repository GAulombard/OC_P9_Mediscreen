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

/**
 * The interface Patient proxy feign.
 */
@FeignClient(value = "patient-api",url="${proxy.patient}")
public interface PatientProxyFeign {

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping({"/list"})
    List<PatientDTO> getAll();

    /**
     * Delete.
     *
     * @param id the id
     */
    @GetMapping({"/delete/{id}"})
    void delete(@PathVariable("id") Integer id);

    /**
     * Validate.
     *
     * @param patientDTO the patient dto
     */
    @PostMapping({"/validate"})
    void validate(PatientDTO patientDTO);

    /**
     * Gets patient by id.
     *
     * @param id the id
     * @return the patient by id
     */
    @GetMapping({"/{id}"})
    PatientDTO getPatientById(@PathVariable("id") Integer id);

    /**
     * Update.
     *
     * @param id         the id
     * @param patientDTO the patient dto
     */
    @PostMapping({"/update/{id}"})
    void update(@PathVariable("id") Integer id, PatientDTO patientDTO);

    /**
     * Gets all by last name.
     *
     * @param familyName the family name
     * @return the all by last name
     */
    @GetMapping("/list/{familyName}")
    List<PatientDTO> getAllByLastName(@PathVariable("familyName") String familyName);
}
