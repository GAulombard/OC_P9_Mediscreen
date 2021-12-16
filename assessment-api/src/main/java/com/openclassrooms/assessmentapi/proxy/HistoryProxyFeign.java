package com.openclassrooms.assessmentapi.proxy;

import com.openclassrooms.assessmentapi.dto.NoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * The interface History proxy feign.
 */
@FeignClient(value = "history-api",url="${proxy.history}")
public interface HistoryProxyFeign {

    /**
     * Gets all.
     *
     * @param id the id
     * @return the all
     */
    @GetMapping({"/list/{id}"})
    List<NoteDTO> getAll(@PathVariable("id") Integer id);

    /**
     * Delete.
     *
     * @param id the id
     */
    @GetMapping({"/delete/{id}"})
    void delete(@PathVariable("id") String id);

    /**
     * Validate.
     *
     * @param noteDTO the note dto
     */
    @PostMapping({"/validate"})
    void validate(@RequestBody NoteDTO noteDTO);

    /**
     * Gets note by id.
     *
     * @param id the id
     * @return the note by id
     */
    @GetMapping({"/{id}"})
    NoteDTO getNoteById(@PathVariable("id") String id);

    /**
     * Update.
     *
     * @param id      the id
     * @param noteDTO the note dto
     */
    @PostMapping({"/update/{id}"})
    void update(@PathVariable("id") String id, @RequestBody NoteDTO noteDTO);

    /**
     * Gets patient id.
     *
     * @param id the id
     * @return the patient id
     */
    @GetMapping({"patient/{id}"})
    Integer getPatientId(@PathVariable("id") String id);

    /**
     * Gets count note per patient.
     *
     * @return the count note per patient
     */
    @GetMapping({"count"})
    Map<Integer,Integer> getCountNotePerPatient();

}
