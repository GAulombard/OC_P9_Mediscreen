package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.model.Note;
import com.openclassrooms.historyapi.repository.HistoryRepository;
import com.openclassrooms.historyapi.util.DTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HistoryServiceImp implements HistoryService{

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private DTOConverter dtoConverter;

    @Override
    public void create(NoteDTO noteDTO) {
        log.info("** Process to save a new note in the database");

        noteDTO.setDate(LocalDate.now(Clock.systemUTC())); //todo:change that to get the real time zone
        historyRepository.save(dtoConverter.NoteDTOToNote(noteDTO));

    }

    @Override
    public NoteDTO readById(String noteId) {
        log.info("** Process to read a note by id");

        Note note = historyRepository.findNoteById(noteId);

        return dtoConverter.NoteToNoteDTO(note);
    }

    @Override
    public void update(String noteId, NoteDTO noteDTO) {
        log.info("** Process to update a note");

        noteDTO.setDate(LocalDate.now(Clock.systemUTC())); //todo:change that to get the real time zone
        Note note = dtoConverter.NoteDTOToNote(noteDTO);

        historyRepository.save(note);

    }

    @Override
    public void deleteById(String noteId) {
        log.info("** Process to delete a note by id");

    }

    @Override
    public List<NoteDTO> readAllByPatientId(Integer patientId) {
        log.info("** Process read all note given a patient's id");

        List<Note> noteList = historyRepository.findNotesByPatientId(patientId);

        log.info(""+noteList);

        List<NoteDTO> noteDTOList = noteList.stream()
                .map(note -> dtoConverter.NoteToNoteDTO(note))
                .collect(Collectors.toList());

        return noteDTOList;
    }
}
