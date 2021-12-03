package com.openclassrooms.patientapi.controller;

import com.openclassrooms.patientapi.exception.PatientNotFoundException;
import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/patient")
@Api(description = "Patient Api")
public class PatientController {

    @Autowired
    private PatientService patientService;

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
        log.info("HTTP GET request received at /patient/delete/"+id);

        patientService.delete(id);

    }

}
