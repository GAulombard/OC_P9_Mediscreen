package com.openclassrooms.patientapi.service;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.exception.PatientAlreadyExistsException;
import com.openclassrooms.patientapi.exception.PatientNotFoundException;
import com.openclassrooms.patientapi.model.Patient;


import java.util.List;


/**
 * The interface Patient service.
 */
public interface PatientService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Patient> getAll();

    /**
     * Gets all by last name.
     *
     * @param lastName the last name
     * @return the all by last name
     */
    List<PatientDTO> getAllByLastName(String lastName);

    /**
     * Delete.
     *
     * @param id the id
     * @throws PatientNotFoundException the patient not found exception
     */
    void delete(Integer id) throws PatientNotFoundException;

    /**
     * Save.
     *
     * @param patientDTO the patient dto
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    void save(PatientDTO patientDTO) throws PatientAlreadyExistsException;

    /**
     * Update.
     *
     * @param patientDTO the patient dto
     * @throws PatientNotFoundException      the patient not found exception
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    void update(PatientDTO patientDTO) throws PatientNotFoundException, PatientAlreadyExistsException;

    /**
     * Find patient by id patient dto.
     *
     * @param id the id
     * @return the patient dto
     * @throws PatientNotFoundException the patient not found exception
     */
    PatientDTO findPatientById(Integer id) throws PatientNotFoundException;

}
