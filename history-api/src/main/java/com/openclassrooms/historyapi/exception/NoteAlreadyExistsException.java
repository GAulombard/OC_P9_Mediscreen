package com.openclassrooms.historyapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Element already exists")
public class NoteAlreadyExistsException extends Throwable {
    public NoteAlreadyExistsException(String note_already_exists) {
        super(note_already_exists);
    }
}
