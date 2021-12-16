package com.openclassrooms.historyapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Note not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Element not Found")
public class NoteNotFoundException extends Throwable {
    /**
     * Instantiates a new Note not found exception.
     *
     * @param note_not_found the note not found
     */
    public NoteNotFoundException(String note_not_found) {
        super(note_not_found);
    }
}
