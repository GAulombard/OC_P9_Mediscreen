package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.AssessmentDTO;
import com.openclassrooms.uiapi.dto.NoteDTO;
import com.openclassrooms.uiapi.dto.PatientDTO;
import com.openclassrooms.uiapi.proxy.AssessmentProxyFeign;
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
import java.util.List;
import java.util.Map;

/**
 * The type Patient controller.
 */
@Controller
@Slf4j
@RequestMapping({"/patient"})
public class PatientController {

    @Autowired
    private PatientProxyFeign patientProxyFeign;

    @Autowired
    private HistoryProxyFeign historyProxyFeign;

    @Autowired
    private AssessmentProxyFeign assessmentProxyFeign;

    /**
     * Gets list.
     *
     * @param model the model
     * @return the list
     */
    @ApiOperation(value = "This URI returns the list of all patients")
    @GetMapping({"/list"})
    public String getList(final Model model) {
        log.info("HTTP GET request received at /patient/list");

        try {
            Map<Integer,Integer> countNotePerPatient = historyProxyFeign.getCountNotePerPatient();
            model.addAttribute("countNotePerPatient",countNotePerPatient);
            model.addAttribute("patients", patientProxyFeign.getAll());
        } catch (Exception e) {
            log.error("" + e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        return "patient/list";
    }

    /**
     * Gets add form.
     *
     * @param model the model
     * @return the add form
     */
    @ApiOperation(value = "This URI returns the form page to add a new patient")
    @GetMapping({"/add"})
    public String getAddForm(final Model model) {
        log.info("HTTP GET request received at /patient/add");

        model.addAttribute("patientDTO", new PatientDTO());

        return "patient/add";
    }

    /**
     * Validate add form string.
     *
     * @param patientDTO    the patient dto
     * @param bindingResult the binding result
     * @param model         the model
     * @return the string
     */
    @ApiOperation(value = "This URI validate the form to add a new patient to the database")
    @PostMapping({"/validate"})
    public String validateAddForm(@Valid @ModelAttribute("patientDTO") PatientDTO patientDTO, BindingResult bindingResult, Model model) {
        log.info("HTTP POST request received at /patient/validate");

        if (bindingResult.hasErrors()) {
            log.error("ERROR(S): {}", bindingResult);
            return "patient/add";
        }

        try {
            patientProxyFeign.validate(patientDTO);
            log.info("New patient saved: "+patientDTO.getFirstName()+" "+patientDTO.getLastName());
        } catch (Exception e) {
            log.error("" + e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        return "redirect:list";
    }

    /**
     * Gets update form.
     *
     * @param id    the id
     * @param model the model
     * @return the update form
     */
    @ApiOperation(value = "This URI returns the form page to update patient's information")
    @GetMapping({"/update/{id}"})
    public String getUpdateForm(@ApiParam(
            value = "the patient id",
            example = "2"
    ) @PathVariable("id") Integer id, final Model model) {
        log.info("HTTP GET request received at /patient/update/" + id);

        PatientDTO patientDTO = null;
        try {
            patientDTO = patientProxyFeign.getPatientById(id);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        model.addAttribute("patientDTO", patientDTO);


        return "patient/update";
    }

    /**
     * Update string.
     *
     * @param id            the id
     * @param patientDTO    the patient dto
     * @param bindingResult the binding result
     * @param model         the model
     * @return the string
     */
    @ApiOperation(value = "This URI update patient's information")
    @PostMapping({"/update/{id}"})
    public String update(@ApiParam(
            value = "the patient id",
            example = "2"
    ) @PathVariable("id") Integer id, @Valid @ModelAttribute("patientDTO") PatientDTO patientDTO, BindingResult bindingResult, final Model model) {
        log.info("HTTP POST request received at /patient/update/" + id);

        if (bindingResult.hasErrors()) {
            log.error("ERROR(S): {}", bindingResult);
            return "patient/update";
        } else {
            try {
                patientProxyFeign.update(id, patientDTO);
            } catch (Exception e) {
                log.error("" + e.getMessage());
                model.addAttribute("errorMsg", e.toString());
                return "error/error";
            }
            return "redirect:/patient/list";
        }
    }

    /**
     * Delete string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @ApiOperation(value = "This URI allow to delete a patient")
    @GetMapping({"/delete/{id}"})
    public String delete(@ApiParam(
            value = "the patient id",
            example = "2"
    ) @PathVariable("id") Integer id, Model model) {
        log.info("HTTP GET request received at /patient/delete/" + id);

        try {
            patientProxyFeign.delete(id);
        } catch (Exception e) {
            log.error("" + e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        return "redirect:/patient/list";
    }

    /**
     * Profile string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @ApiOperation(value = "This URI returns the patient's profile page")
    @GetMapping({"/profile/{id}"})
    public String profile(@ApiParam(
            value = "the patient id",
            example = "2"
    ) @PathVariable("id") Integer id, Model model) {
        log.info("HTTP GET request received at /patient/profile/" + id);

        PatientDTO patientDTO = null;
        List<NoteDTO> noteDTOList = null;
        AssessmentDTO assessmentDTO = null;

        try {
            patientDTO = patientProxyFeign.getPatientById(id);
            noteDTOList = historyProxyFeign.getAll(id);
            assessmentDTO = assessmentProxyFeign.getPatientAssessment(id);
        } catch (FeignException e) {
            log.error("" + e.getMessage());
            model.addAttribute("errorMsg", e.toString());
            return "error/error";
        }

        model.addAttribute("noteDTOList", noteDTOList);
        model.addAttribute("patientDTO", patientDTO);
        model.addAttribute("assessmentDTO",assessmentDTO);

        return "patient/profile";
    }

}
