package com.openclassrooms.patientapi.repository;

import com.openclassrooms.patientapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    boolean existsByLastNameAndFirstNameAndBirthDate(String lastName, String firstName, LocalDate birthDate);

}
