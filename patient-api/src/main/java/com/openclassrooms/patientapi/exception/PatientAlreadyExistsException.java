package com.openclassrooms.patientapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Patient already exists exception.
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Element already exists")
public class PatientAlreadyExistsException extends Exception{
    /**
     * Instantiates a new Patient already exists exception.
     *
     * @param s the s
     */
    public PatientAlreadyExistsException(String s) {
        super(s);
    }
}
