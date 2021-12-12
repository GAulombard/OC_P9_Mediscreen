package com.openclassrooms.uiapi.proxy;

import com.openclassrooms.uiapi.dto.NoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(value = "history-api",url="${proxy.history}")
public interface HistoryProxyFeign {

    @GetMapping({"/list/{id}"})
    List<NoteDTO> getAll(@PathVariable("id") Integer id);

    @GetMapping({"/delete/{id}"})
    void delete(@PathVariable("id") String id);

    @PostMapping({"/validate"})
    void validate(@RequestBody NoteDTO noteDTO);

    @GetMapping({"/{id}"})
    NoteDTO getNoteById(@PathVariable("id") String id);

    @PostMapping({"/update/{id}"})
    void update(@PathVariable("id") String id, @RequestBody NoteDTO noteDTO);

    @GetMapping({"patient/{id}"})
    Integer getPatientId(@PathVariable("id") String id);

    @GetMapping({"count"})
    Map<Integer,Integer> getCountNotePerPatient();

}
