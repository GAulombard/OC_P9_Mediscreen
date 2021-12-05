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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/patient")
@Api(description = "Patient Api")
public class PatientController {

    @Autowired
    private PatientService patientService;

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

    @GetMapping("/list")
    @ApiOperation(value = "This URI returns a list of all patient saved in database.")
    public List<Patient> getAll() {
        log.info("HTTP GET request received at /patient/list");

        List<Patient> resultList = patientService.getAll();

        return resultList;
    }

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

    @PostMapping("/validate")
    @ApiOperation(value = "This uri validate the patient form to save a new patient in the database.")
    public void validate(@Valid @RequestBody PatientDTO patientDTO) throws PatientAlreadyExistsException {
        log.info("HTTP POST request received at /patient/validate");

        patientService.save(patientDTO);

    }

    @PostMapping("/update/{id}")
    @ApiOperation(value = "This uri validate the patient form to save a new patient in the database.")
    public void update(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id, @Valid @RequestBody PatientDTO patientDTO) throws PatientNotFoundException {
        log.info("HTTP POST request received at /patient/update/" + id);

        patientService.update(patientDTO);

    }

}
