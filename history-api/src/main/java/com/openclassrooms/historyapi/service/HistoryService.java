package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteAlreadyExistsException;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface HistoryService {

    void create(NoteDTO noteDTO) throws NoteAlreadyExistsException;

    NoteDTO readById(String noteId) throws NoteNotFoundException;

    void update(String noteId, NoteDTO noteDTO) throws NoteNotFoundException;

    void deleteById(String noteId) throws NoteNotFoundException;

    List<NoteDTO> readAllByPatientId(Integer patientId);

    Integer findPatientIdByNoteId(String noteId) throws NoteNotFoundException;

    Map<Integer,Integer> countNotesPerPatient();

}
