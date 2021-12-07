package com.openclassrooms.historyapi.util;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.model.Note;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    public NoteDTO NoteToNoteDTO(Note note) {

        return new NoteDTO(note.getId(), note.getPatientId(), note.getDate(),note.getNote());
    }

    public Note NoteDTOToNote(NoteDTO note) {

        return new Note(note.getId(), note.getPatientId(), note.getDate(),note.getNote());
    }

}
