package com.openclassrooms.historyapi.controller;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteAlreadyExistsException;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import com.openclassrooms.historyapi.service.HistoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/{id}")
    @ApiOperation(value = "This URI returns a note by id")
    public NoteDTO getNoteById(@ApiParam(
            value = "id",
            example = "61b1daec21efc6385fca1920"
    ) @PathVariable("id") String id) throws NoteNotFoundException {
        log.info("HTTP GET request received at /history/" + id);

        NoteDTO noteDTO = historyService.readById(id);

        return noteDTO;
    }

    @GetMapping("/list/{id}")
    @ApiOperation(value = "This URI returns a list of all patient's notes saved in database given the patient's id.")
    public List<NoteDTO> getAll(@ApiParam(
            value = "id",
            example = "2"
    ) @PathVariable("id") Integer id) {
        log.info("HTTP GET request received at /history/list/" + id);

        List<NoteDTO> resultList = historyService.readAllByPatientId(id);

        return resultList;
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "This URI allows to delete a note from the database")
    public void delete(@ApiParam(
            value = "id",
            example = "61b1daec21efc6385fca1920"
    )
                       @PathVariable("id") String id) throws NoteNotFoundException {
        log.info("HTTP GET request received at /history/delete/" + id);

        historyService.deleteById(id);

    }

    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "This uri validate the note's form to save a new note in the database.")
    public void validate(@RequestBody NoteDTO noteDTO) throws NoteAlreadyExistsException {
        log.info("HTTP POST request received at /history/validate");

        historyService.create(noteDTO);

    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "This uri validate the note's form to update a patient's note in the database.")
    public void update(@ApiParam(
            value = "id",
            example = "61b1daec21efc6385fca1920"
    ) @PathVariable("id") String id, @RequestBody NoteDTO noteDTO) throws NoteNotFoundException {
        log.info("HTTP POST request received at /history/update/" + id);

        historyService.update(id, noteDTO);

    }

    @GetMapping("/patient/{id}")
    @ApiOperation(value = "This URI returns the patient id given a note id")
    public Integer getPatientId(@ApiParam(
            value = "id",
            example = "61b1daec21efc6385fca1920"
    )
                       @PathVariable("id") String id) throws NoteNotFoundException {
        log.info("HTTP GET request received at /history/patient/" + id);

        return historyService.findPatientIdByNoteId(id);

    }

    @GetMapping("/count")
    @ApiOperation(value = "This URI returns the number of notes by patient id.")
    public Map<Integer,Integer> getCountNotePerPatient() {
        log.info("HTTP GET request received at /history/count");

        return historyService.countNotesPerPatient();
    }

}
