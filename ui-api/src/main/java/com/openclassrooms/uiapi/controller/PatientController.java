package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.PatientDTO;
import com.openclassrooms.uiapi.proxy.PatientProxyFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

        model.addAttribute("patientDTO",new PatientDTO());

        return "patient/add";
    }

    @ApiOperation(value = "This URI validate the for to add a new patient to the database")
    @PostMapping({"/validate"})
    public String validateAddForm(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO, BindingResult bindingResult) {
        log.info("HTTP POST request received at /patient/validate");

        if(bindingResult.hasErrors()) {
            log.error("ERROR(S): {}",bindingResult);
            return "patient/add";
        }

        try {
            patientProxyFeign.validate(patientDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:list";
    }

    @ApiOperation(value = "This URI returns the form page to update patient's information")
    @GetMapping({"/update/{id}"})
    public String getUpdateForm(@PathVariable("id") Integer id, final Model model) {
        log.info("HTTP GET request received at /patient/update/"+id);

        PatientDTO patientDTO = patientProxyFeign.getPatientById(id);
        model.addAttribute("patientDTO",patientDTO);


        return "patient/update";
    }

    @ApiOperation(value = "This URI update patient's information")
    @PostMapping({"/update/{id}"})
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("patientDTO") PatientDTO patientDTO, BindingResult bindingResult, final Model model) {
        log.info("HTTP POST request received at /patient/update/"+id+"");

        if (bindingResult.hasErrors()) {
            return "patient/update/"+id;
        } else {
            patientProxyFeign.update(id,patientDTO);
            return "redirect:/patient/list";
        }
    }

    @ApiOperation(value = "This URI allow to delete a patient")
    @GetMapping({"/delete/{id}"})
    public String delete(@PathVariable("id") Integer id) {
        log.info("HTTP GET request received at /patient/delete/"+id);

        try {
            patientProxyFeign.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/patient/list";
    }

}
