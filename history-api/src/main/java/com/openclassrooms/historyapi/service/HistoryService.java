package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteAlreadyExistsException;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * The interface History service.
 */
@Service
public interface HistoryService {

    /**
     * Create.
     *
     * @param noteDTO the note dto
     * @throws NoteAlreadyExistsException the note already exists exception
     */
    void create(NoteDTO noteDTO) throws NoteAlreadyExistsException;

    /**
     * Read by id note dto.
     *
     * @param noteId the note id
     * @return the note dto
     * @throws NoteNotFoundException the note not found exception
     */
    NoteDTO readById(String noteId) throws NoteNotFoundException;

    /**
     * Update.
     *
     * @param noteId  the note id
     * @param noteDTO the note dto
     * @throws NoteNotFoundException the note not found exception
     */
    void update(String noteId, NoteDTO noteDTO) throws NoteNotFoundException;

    /**
     * Delete by id.
     *
     * @param noteId the note id
     * @throws NoteNotFoundException the note not found exception
     */
    void deleteById(String noteId) throws NoteNotFoundException;

    /**
     * Read all by patient id list.
     *
     * @param patientId the patient id
     * @return the list
     */
    List<NoteDTO> readAllByPatientId(Integer patientId);

    /**
     * Find patient id by note id integer.
     *
     * @param noteId the note id
     * @return the integer
     * @throws NoteNotFoundException the note not found exception
     */
    Integer findPatientIdByNoteId(String noteId) throws NoteNotFoundException;

    /**
     * Count notes per patient map.
     *
     * @return the map
     */
    Map<Integer,Integer> countNotesPerPatient();

}
