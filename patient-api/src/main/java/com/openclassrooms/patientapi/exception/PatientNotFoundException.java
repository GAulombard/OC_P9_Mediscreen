package com.openclassrooms.patientapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Patient not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Element not Found")
public class PatientNotFoundException extends Exception {
    /**
     * Instantiates a new Patient not found exception.
     *
     * @param s the s
     */
    public PatientNotFoundException(String s) {
        super(s);
    }
}
