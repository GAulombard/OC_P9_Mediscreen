package com.openclassrooms.patientapi.repository;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * The interface Patient repository.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    /**
     * Exists by last name and first name and birth date boolean.
     *
     * @param lastName  the last name
     * @param firstName the first name
     * @param birthDate the birth date
     * @return the boolean
     */
    boolean existsByLastNameAndFirstNameAndBirthDate(String lastName, String firstName, LocalDate birthDate);

    /**
     * Find all by last name list.
     *
     * @param lastName the last name
     * @return the list
     */
    List<Patient> findAllByLastName(String lastName);

    /**
     * Find patient by last name and first name and birth date patient.
     *
     * @param lastName  the last name
     * @param firstName the first name
     * @param birthDate the birth date
     * @return the patient
     */
    Patient findPatientByLastNameAndFirstNameAndBirthDate(String lastName,String firstName, LocalDate birthDate);

}
