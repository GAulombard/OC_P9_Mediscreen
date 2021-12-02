package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.proxy.PatientProxyFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Validated
@Api(description = "Patient API")
@Slf4j
@RequestMapping({"/patient"})
public class PatientController {

    @Autowired
    private PatientProxyFeign patientProxyFeign;

    @ApiOperation(value = "This URI returns the list of all patients")
    @GetMapping({"/list"})
    public String getList(final Model model) {
        log.info("HTTP GET request received at /patient/list");

        try {
            model.addAttribute("patients",patientProxyFeign.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "patient/list";
    }

    @ApiOperation(value = "This URI returns the form page to add a new patient")
    @GetMapping({"/add"})
    public String getAddForm(final Model model) {
        log.info("HTTP GET request received at /patient/add");

        return "patient/add";
    }

    @ApiOperation(value = "This URI add a new patient to the list")
    @PostMapping({"/validate"})
    public String validateAddForm() {
        log.info("HTTP POST request received at /patient/validate");

        return "redirect:patient/list";
    }

    @ApiOperation(value = "This URI returns the form page to update patient's information")
    @GetMapping({"/update/{id}"})
    public String getUpdateForm(@PathVariable("id") Integer id, final Model model) {
        log.info("HTTP GET request received at /patient/update/"+id+"");

        return "patient/update";
    }

    @ApiOperation(value = "This URI update patient's information")
    @PostMapping({"/update/{id}"})
    public String update(@PathVariable("id") Integer id, final Model model) {
        log.info("HTTP POST request received at /patient/update/"+id+"");

        return "redirect:patient/list";
    }

    @ApiOperation(value = "This URI allow to delete a patient")
    @GetMapping({"/delete/{id}"})
    public String delete(@PathVariable("id") Integer id) {
        log.info("HTTP GET request received at /patient/delete/"+id+"");

        return "redirect:patient/list";
    }

}
