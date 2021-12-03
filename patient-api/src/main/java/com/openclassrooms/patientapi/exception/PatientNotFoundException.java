package com.openclassrooms.patientapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Element not Found")
public class PatientNotFoundException extends Exception {
    public PatientNotFoundException(String s) {
        super(s);
    }
}
