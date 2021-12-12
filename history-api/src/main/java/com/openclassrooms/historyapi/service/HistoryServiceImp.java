package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteAlreadyExistsException;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import com.openclassrooms.historyapi.model.Note;
import com.openclassrooms.historyapi.model.NoteCounter;
import com.openclassrooms.historyapi.repository.HistoryRepository;
import com.openclassrooms.historyapi.util.DTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            throw new NoteAlreadyExistsException("Note already exists");//fixme: show error 500 internal server error on view instead of 409 conflict
        }

        historyRepository.save(noteToSave);

        log.info("** Saving new note succeed, noteId: "+noteToSave.getId());

    }

    @Override
    public NoteDTO readById(String noteId) throws NoteNotFoundException {
        log.info("** Process to read a note by id");

        if(!historyRepository.existsById(noteId)) throw new NoteNotFoundException("Note not found");

        Note note = historyRepository.findNoteById(noteId);

        return dtoConverter.NoteToNoteDTO(note);
    }

    @Override
    public void update(String noteId, NoteDTO noteDTO) throws NoteNotFoundException {
        log.info("** Process to update a note");

        if(!historyRepository.existsById(noteId)) throw new NoteNotFoundException("Note not found");

        noteDTO.setDate(LocalDate.now(Clock.systemUTC())); //todo:change that to get the real time zone
        Note note = dtoConverter.NoteDTOToNote(noteDTO);

        historyRepository.save(note);

        log.info("** Updating note succeed, noteId: "+note.getId());

    }

    @Override
    public void deleteById(String noteId) throws NoteNotFoundException {
        log.info("** Process to delete a note by id");

        if(!historyRepository.existsById(noteId)) throw new NoteNotFoundException("Note not found");

        historyRepository.deleteById(noteId);

        log.info("** Deleting note succeed, noteId: "+noteId);

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
    public Integer findPatientIdByNoteId(String noteId) throws NoteNotFoundException {

        if(!historyRepository.existsById(noteId)) throw new NoteNotFoundException("Note not found");

        Note note = historyRepository.findNoteById(noteId);

        return note.getPatientId();
    }

    @Override
    public Map<Integer, Integer> countNotesPerPatient() {
        AggregationResults<NoteCounter> aggregationResults = historyRepository.countNotesPerPatient();

        List<NoteCounter> noteCounters = aggregationResults.getMappedResults();
        Map<Integer, Integer> mapNoteCounters = new HashMap<>();

        for( NoteCounter noteCounter : noteCounters ) {
            mapNoteCounters.put( noteCounter.getPatientId(), noteCounter.getNrbNote());
        }

        return mapNoteCounters;

    }

}
