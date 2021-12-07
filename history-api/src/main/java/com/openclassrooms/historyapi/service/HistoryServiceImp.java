package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImp implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void create(NoteDTO noteDTO) {

    }

    @Override
    public NoteDTO readById(String noteId) {
        return null;
    }

    @Override
    public void update(String noteId, NoteDTO noteDTO) {

    }

    @Override
    public void deleteById(String noteId) {

    }

    @Override
    public List<NoteDTO> readAllByPatientId(Integer patientId) {
        return null;
    }
}
