package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.NoteDTO;
import com.openclassrooms.uiapi.dto.PatientDTO;
import com.openclassrooms.uiapi.proxy.HistoryProxyFeign;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.constraintvalidators.bv.time.future.FutureValidatorForLocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@Slf4j
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryProxyFeign historyProxyFeign;

    @ApiOperation(value = "This URI returns the history list of a patient")
    @GetMapping({"/list/{id}"})
    public String getList(@PathVariable("id") Integer id, Model model) {
        log.info("HTTP GET request received at /history/list/"+id);

        try {
            model.addAttribute("historyList", historyProxyFeign.getAll(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "history/list";
    }

    @ApiOperation(value = "This URI returns the form page to add a new patient's history")
    @GetMapping({"/add/{id}"})
    public String getAddForm(@PathVariable("id") Integer patientId, Model model) {
        log.info("HTTP GET request received at /history/add/"+patientId);

        NoteDTO  noteDTO = new NoteDTO();
        noteDTO.setPatientId(patientId);

        model.addAttribute("noteDTO", noteDTO);

        return "history/add";
    }

    @ApiOperation(value = "This URI validate the form to add a new patient history to the database")
    @PostMapping({"/validate"})
    public String validateAddForm(@ModelAttribute("noteDTO") NoteDTO noteDTO, BindingResult bindingResult) {
        log.info("HTTP POST request received at /history/validate");

        try {
            historyProxyFeign.validate(noteDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:list";
    }

}
