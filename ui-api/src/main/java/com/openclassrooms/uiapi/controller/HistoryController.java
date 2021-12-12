package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.NoteDTO;
import com.openclassrooms.uiapi.dto.PatientDTO;
import com.openclassrooms.uiapi.proxy.HistoryProxyFeign;
import com.openclassrooms.uiapi.proxy.PatientProxyFeign;
import feign.FeignException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@Slf4j
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryProxyFeign historyProxyFeign;

    @Autowired
    private PatientProxyFeign patientProxyFeign;

    @ApiOperation(value = "This URI returns the history list of a patient")
    @GetMapping({"/list/{id}"})
    public String getList(@PathVariable("id") Integer id, Model model) {
        log.info("HTTP GET request received at /history/list/" + id);

        try {
            model.addAttribute("historyList", historyProxyFeign.getAll(id));
        } catch (Exception e) {
            log.error("" + e.getMessage());
            //model.addAttribute("errorStatus",e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        return "history/list";
    }

    @ApiOperation(value = "This URI returns the form page to add a new patient's history")
    @GetMapping({"/add/{id}"})
    public String getAddForm(@PathVariable("id") Integer patientId, Model model) {
        log.info("HTTP GET request received at /history/add/" + patientId);

        try {
            PatientDTO patientDTO = patientProxyFeign.getPatientById(patientId);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            //model.addAttribute("errorStatus",e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setPatientId(patientId);

        model.addAttribute("noteDTO", noteDTO);

        return "history/add";
    }

    @ApiOperation(value = "This URI validate the form to add a new patient history to the database")
    @PostMapping({"/validate"})
    public String validateAddForm(@ModelAttribute("noteDTO") NoteDTO noteDTO, BindingResult bindingResult, Model model) {
        log.info("HTTP POST request received at /history/validate");

        try {
            historyProxyFeign.validate(noteDTO);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            //model.addAttribute("errorStatus",e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        return "redirect:/patient/profile/" + noteDTO.getPatientId();
    }

    @ApiOperation(value = "This URI returns the form page to update patient's note")
    @GetMapping({"/update/{id}"})
    public String getUpdateForm(@ApiParam(
            value = "id",
            example = "61b1daec21efc6385fca1920"
    ) @PathVariable("id") String id, final Model model) {
        log.info("HTTP GET request received at /history/update/" + id);

        NoteDTO noteDTO = null;

        try {
            noteDTO = historyProxyFeign.getNoteById(id);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            //model.addAttribute("errorStatus",e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        model.addAttribute("noteDTO", noteDTO);


        return "history/update";
    }

    @ApiOperation(value = "This URI update patient's note history")
    @PostMapping({"/update/{id}"})
    public String update(@ApiParam(
            value = "id",
            example = "61b1daec21efc6385fca1920"
    ) @PathVariable("id") String id, @ModelAttribute("noteDTO") NoteDTO noteDTO, BindingResult bindingResult, Model model) {
        log.info("HTTP POST request received at /history/update/" + id);

        try {
            historyProxyFeign.update(id, noteDTO);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            //model.addAttribute("errorStatus",e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        return "redirect:/patient/profile/" + noteDTO.getPatientId();
    }

    @ApiOperation(value = "This URI allows to delete a note from the patient's history")
    @GetMapping({"/delete/{id}"})
    public String delete(@ApiParam(
            value = "id",
            example = "61b1daec21efc6385fca1920"
    ) @PathVariable("id") String id, final Model model) {
        log.info("HTTP GET request received at /history/delete/" + id);

        Integer patientId = null;

        try {
            patientId = historyProxyFeign.getPatientId(id);
            historyProxyFeign.delete(id);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            //model.addAttribute("errorStatus",e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        return "redirect:/patient/profile/" + patientId;
    }

}
