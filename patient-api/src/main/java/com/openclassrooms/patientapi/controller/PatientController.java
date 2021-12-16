package com.openclassrooms.patientapi.controller;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.exception.PatientAlreadyExistsException;
import com.openclassrooms.patientapi.exception.PatientNotFoundException;
import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Patient controller.
 */
@RestController
@Slf4j
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * Gets patient by id.
     *
     * @param id the id
     * @return the patient by id
     * @throws PatientNotFoundException the patient not found exception
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "This URI returns a patient by id")
    public PatientDTO getPatientById(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id) throws PatientNotFoundException {
        log.info("HTTP GET request received at /patient/" + id);

        PatientDTO patientDTO = patientService.findPatientById(id);

        return patientDTO;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping("/list")
    @ApiOperation(value = "This URI returns a list of all patient saved in database.")
    public List<Patient> getAll() {
        log.info("HTTP GET request received at /patient/list");

        List<Patient> resultList = patientService.getAll();

        return resultList;
    }

    /**
     * Gets all by last name.
     *
     * @param familyName the family name
     * @return the all by last name
     */
    @GetMapping("/list/{familyName}")
    @ApiOperation(value = "This URI returns a list of all patients with the same family name.")
    public List<PatientDTO> getAllByLastName(@ApiParam(
            value = "familyName",
            example = "Arnold"
    )@PathVariable("familyName") String familyName) {
        log.info("HTTP GET request received at /patient/list/"+familyName);

        List<PatientDTO> resultList = patientService.getAllByLastName(familyName);

        return resultList;
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws PatientNotFoundException the patient not found exception
     */
    @GetMapping("/delete/{id}")
    @ApiOperation(value = "This URI allows to delete a patient from the database")
    public void delete(
            @ApiParam(
                    value = "id",
                    example = "2"
            )
            @PathVariable("id") Integer id) throws PatientNotFoundException {
        log.info("HTTP GET request received at /patient/delete/" + id);

        patientService.delete(id);

    }

    /**
     * Validate.
     *
     * @param patientDTO the patient dto
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "This uri validate the patient form to save a new patient in the database.")
    public void validate(@Valid @RequestBody PatientDTO patientDTO) throws PatientAlreadyExistsException {
        log.info("HTTP POST request received at /patient/validate");

        patientService.save(patientDTO);

    }

    /**
     * Update.
     *
     * @param id         the id
     * @param patientDTO the patient dto
     * @throws PatientNotFoundException the patient not found exception
     */
    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "This uri validate the patient's form to update a patient's personal information in the database.")
    public void update(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id, @Valid @RequestBody PatientDTO patientDTO) throws PatientNotFoundException {
        log.info("HTTP POST request received at /patient/update/" + id);

        patientService.update(patientDTO);

    }

}
