package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoryService {

    void create(NoteDTO noteDTO);

    NoteDTO readById(String noteId);

    void update(String noteId, NoteDTO noteDTO);

    void deleteById(String noteId);

    List<NoteDTO> readAllByPatientId(Integer patientId);

}
