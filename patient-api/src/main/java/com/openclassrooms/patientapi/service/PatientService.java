package com.openclassrooms.patientapi.service;

import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAll() {
        log.info("** Process to get all patients");
        return patientRepository.findAll(Sort.by(Sort.Direction.ASC,"lastName"));
    }

}
