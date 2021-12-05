package com.openclassrooms.patientapi.service;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.exception.PatientAlreadyExistsException;
import com.openclassrooms.patientapi.exception.PatientNotFoundException;
import com.openclassrooms.patientapi.model.Patient;


import java.util.List;


public interface PatientService {

    List<Patient> getAll();

    void delete(Integer id) throws PatientNotFoundException;

    void save(PatientDTO patientDTO) throws PatientAlreadyExistsException;

    void update(PatientDTO patientDTO) throws PatientNotFoundException;

    PatientDTO findPatientById(Integer id) throws PatientNotFoundException;

}
