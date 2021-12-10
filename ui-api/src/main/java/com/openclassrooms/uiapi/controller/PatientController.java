package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.NoteDTO;
import com.openclassrooms.uiapi.dto.PatientDTO;
import com.openclassrooms.uiapi.proxy.HistoryProxyFeign;
import com.openclassrooms.uiapi.proxy.PatientProxyFeign;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping({"/patient"})
public class PatientController {

    @Autowired
    private PatientProxyFeign patientProxyFeign;

    @Autowired
    private HistoryProxyFeign historyProxyFeign;

    @ApiOperation(value = "This URI returns the list of all patients")
    @GetMapping({"/list"})
    public String getList(final Model model) {
        log.info("HTTP GET request received at /patient/list");

        //todo: add counter of all notes per patient, using map<,> seems to be a good way. See aggregation for mongo db

        try {
            model.addAttribute("patients", patientProxyFeign.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "patient/list";
    }

    @ApiOperation(value = "This URI returns the form page to add a new patient")
    @GetMapping({"/add"})
    public String getAddForm(final Model model) {
        log.info("HTTP GET request received at /patient/add");

        model.addAttribute("patientDTO", new PatientDTO());

        return "patient/add";
    }

    @ApiOperation(value = "This URI validate the form to add a new patient to the database")
    @PostMapping({"/validate"})
    public String validateAddForm(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO, BindingResult bindingResult) {
        log.info("HTTP POST request received at /patient/validate");

        if (bindingResult.hasErrors()) {
            log.error("ERROR(S): {}", bindingResult);
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
    public String getUpdateForm(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id, final Model model) {
        log.info("HTTP GET request received at /patient/update/" + id);

        PatientDTO patientDTO = patientProxyFeign.getPatientById(id);
        model.addAttribute("patientDTO", patientDTO);


        return "patient/update";
    }

    @ApiOperation(value = "This URI update patient's information")
    @PostMapping({"/update/{id}"})
    public String update(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id, @Valid @ModelAttribute("patientDTO") PatientDTO patientDTO, BindingResult bindingResult, final Model model) {
        log.info("HTTP POST request received at /patient/update/" + id);

        if (bindingResult.hasErrors()) {
            log.error("ERROR(S): {}", bindingResult);
            return "patient/update";
        } else {
            patientProxyFeign.update(id, patientDTO);
            return "redirect:/patient/list";
        }
    }

    @ApiOperation(value = "This URI allow to delete a patient")
    @GetMapping({"/delete/{id}"})
    public String delete(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id) {
        log.info("HTTP GET request received at /patient/delete/" + id);

        try {
            patientProxyFeign.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/patient/list";
    }

    @ApiOperation(value = "This URI returns the patient's profile page")
    @GetMapping({"/profile/{id}"})
    public String profile(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id, Model model) {
        log.info("HTTP GET request received at /patient/profile/" + id);

        PatientDTO patientDTO = patientProxyFeign.getPatientById(id);
        List<NoteDTO> noteDTOList = historyProxyFeign.getAll(id);

        model.addAttribute("noteDTOList",noteDTOList);
        model.addAttribute("patientDTO", patientDTO);

        return "patient/profile";
    }

}
