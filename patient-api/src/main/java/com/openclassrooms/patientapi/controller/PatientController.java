package com.openclassrooms.patientapi.controller;

import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
