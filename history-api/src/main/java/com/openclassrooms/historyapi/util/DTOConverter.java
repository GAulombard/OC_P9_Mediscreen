package com.openclassrooms.historyapi.util;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.model.Note;
import org.springframework.stereotype.Component;

/**
 * The type Dto converter.
 */
@Component
public class DTOConverter {

    /**
     * Note to note dto note dto.
     *
     * @param note the note
     * @return the note dto
     */
    public NoteDTO NoteToNoteDTO(Note note) {

        return new NoteDTO(note.getId(), note.getPatientId(), note.getDate(),note.getNote());
    }

    /**
     * Note dto to note note.
     *
     * @param note the note
     * @return the note
     */
    public Note NoteDTOToNote(NoteDTO note) {

        return new Note(note.getId(), note.getPatientId(), note.getDate(),note.getNote());
    }

}
