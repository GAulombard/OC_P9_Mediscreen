package com.openclassrooms.patientapi.service;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.exception.PatientAlreadyExistsException;
import com.openclassrooms.patientapi.exception.PatientNotFoundException;
import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.repository.PatientRepository;
import com.openclassrooms.patientapi.util.DTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Patient service imp.
 */
@Service
@Slf4j
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DTOConverter dtoConverter;

    @Override
    public List<Patient> getAll() {
        log.info("** Process to get all patients");

        return patientRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));

    }

    @Override
    public List<PatientDTO> getAllByLastName(String lastName) {

        List<Patient> patientList = patientRepository.findAllByLastName(lastName);
        List<PatientDTO> patientDTOList = new ArrayList<>();

        patientList.forEach(patient -> {
            patientDTOList.add(dtoConverter.PatientToPatientDTO(patient));
        });


        return patientDTOList;
    }

    @Override
    public void delete(Integer id) throws PatientNotFoundException {
        log.info("** Process to delete 1 patient, id: "+id);

        if(patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            log.info("** delete succeed");

        } else {
            throw new PatientNotFoundException("Patient with id: "+id+" not found");
        }
    }

    @Override
    public void save(PatientDTO patientDTO) throws PatientAlreadyExistsException {
        log.info("** Process to save a new patient in database");

        if(patientRepository.existsByLastNameAndFirstNameAndBirthDate(patientDTO.getLastName(),patientDTO.getFirstName(),patientDTO.getBirthDate())) {
            throw new PatientAlreadyExistsException("Patient already exists");
        }

        Patient patientToSave = dtoConverter.PatientDTOToPatient(patientDTO);


        patientRepository.save(patientToSave);

    }

    @Override
    public void update(PatientDTO patientDTO) throws PatientNotFoundException, PatientAlreadyExistsException {
        log.info("** Process to update an existing patient in database");

        Patient patientToUpdate = dtoConverter.PatientDTOToPatient(patientDTO);

        if(!patientRepository.existsById(patientToUpdate.getId())) throw new PatientNotFoundException("Patient not found");

        if(patientRepository.existsByLastNameAndFirstNameAndBirthDate(patientToUpdate.getLastName(),patientToUpdate.getFirstName(),patientToUpdate.getBirthDate())) {
            Patient alreadyExistingPatient = patientRepository.findPatientByLastNameAndFirstNameAndBirthDate(patientToUpdate.getLastName(),patientToUpdate.getFirstName(),patientToUpdate.getBirthDate());
            if(patientToUpdate.getId() != alreadyExistingPatient.getId()) throw new PatientAlreadyExistsException("Patient with those information already exists");
        }

        patientRepository.save(patientToUpdate);

    }

    @Override
    public PatientDTO findPatientById(Integer id) throws PatientNotFoundException {
        log.info("** Process de find a patient by id");

        if(!patientRepository.existsById(id)) throw new PatientNotFoundException("Patient not found with this id");

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with this id"));


        return dtoConverter.PatientToPatientDTO(patient);
    }
}
