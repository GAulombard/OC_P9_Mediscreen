package com.openclassrooms.patientapi.util;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.model.Patient;
import org.springframework.stereotype.Component;

/**
 * The type Dto converter.
 */
@Component
public class DTOConverter {

    /**
     * Patient to patient dto patient dto.
     *
     * @param patient the patient
     * @return the patient dto
     */
    public PatientDTO PatientToPatientDTO(Patient patient) {

        return new PatientDTO(patient.getId(), patient.getLastName(), patient.getFirstName(), patient.getBirthDate(),
                patient.getSex(), patient.getAddress(), patient.getPhoneNumber());
    }

    /**
     * Patient dto to patient patient.
     *
     * @param patient the patient
     * @return the patient
     */
    public Patient PatientDTOToPatient(PatientDTO patient) {

        return new Patient(patient.getId(), patient.getLastName(), patient.getFirstName(), patient.getBirthDate(),
                patient.getSex(), patient.getAddress(), patient.getPhoneNumber());
    }

}
