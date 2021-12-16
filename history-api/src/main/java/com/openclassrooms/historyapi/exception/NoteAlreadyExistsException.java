package com.openclassrooms.historyapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Note already exists exception.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Element already exists")
public class NoteAlreadyExistsException extends Throwable {
    /**
     * Instantiates a new Note already exists exception.
     *
     * @param note_already_exists the note already exists
     */
    public NoteAlreadyExistsException(String note_already_exists) {
        super(note_already_exists);
    }
}
