package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteAlreadyExistsException;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import com.openclassrooms.historyapi.model.Note;
import com.openclassrooms.historyapi.repository.HistoryRepository;
import com.openclassrooms.historyapi.util.DTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
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
    public void create(NoteDTO noteDTO) throws NoteAlreadyExistsException {
        log.info("** Process to save a new note in the database");

        noteDTO.setDate(LocalDate.now(Clock.systemUTC())); //todo:change that to get the real time zone
        Note noteToSave = dtoConverter.NoteDTOToNote(noteDTO);

        if(historyRepository.existsByNoteAndPatientIdAndDate(noteToSave.getNote(),noteToSave.getPatientId(),noteToSave.getDate())) {
            throw new NoteAlreadyExistsException("Note already exists");
        }

        historyRepository.save(noteToSave);

    }

    @Override
    public NoteDTO readById(String noteId) throws NoteNotFoundException {
        log.info("** Process to read a note by id");

        if(!historyRepository.existsById(noteId)) throw new NoteNotFoundException("Note not found");

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

        historyRepository.deleteById(noteId);

    }

    @Override
    public List<NoteDTO> readAllByPatientId(Integer patientId) {
        log.info("** Process read all note given a patient's id");

        List<Note> noteList = historyRepository.findNotesByPatientId(patientId);

        List<NoteDTO> noteDTOList = noteList.stream()
                .map(note -> dtoConverter.NoteToNoteDTO(note))
                .collect(Collectors.toList());

        return noteDTOList;
    }

    @Override
    public Integer findPatientIdByNoteId(String noteId) {

        Note note = historyRepository.findNoteById(noteId);

        return note.getPatientId();
    }
}
