package com.openclassrooms.historyapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Element not Found")
public class NoteNotFoundException extends Throwable {
    public NoteNotFoundException(String note_not_found) {
        super(note_not_found);
    }
}
