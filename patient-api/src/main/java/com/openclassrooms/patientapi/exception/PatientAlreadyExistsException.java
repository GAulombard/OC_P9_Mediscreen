package com.openclassrooms.patientapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Element already exists")
public class PatientAlreadyExistsException extends Exception{
    public PatientAlreadyExistsException(String s) {
        super(s);
    }
}
