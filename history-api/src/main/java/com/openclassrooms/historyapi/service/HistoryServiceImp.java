package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.repository.HistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HistoryServiceImp implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void create(NoteDTO noteDTO) {
        log.info("** Process to save a new note in the database");

    }

    @Override
    public NoteDTO readById(String noteId) {
        log.info("** Process to read a note by id");

        return null;
    }

    @Override
    public void update(String noteId, NoteDTO noteDTO) {
        log.info("** Process to update a note");

    }

    @Override
    public void deleteById(String noteId) {
        log.info("** Process to delete a note by id");

    }

    @Override
    public List<NoteDTO> readAllByPatientId(Integer patientId) {
        log.info("** Process read all note form a patient's id");

        return null;
    }
}
