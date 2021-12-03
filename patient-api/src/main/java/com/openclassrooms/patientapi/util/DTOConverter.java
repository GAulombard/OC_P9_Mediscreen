package com.openclassrooms.patientapi.util;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    public PatientDTO PatientToPatientDTO(Patient patient) {

        return new PatientDTO(patient.getId(), patient.getLastName(), patient.getFirstName(), patient.getBirthDate(),
                patient.getSex(), patient.getAddress(), patient.getPhoneNumber());
    }

    public Patient PatientDTOToPatient(PatientDTO patient) {

        return new Patient(patient.getId(), patient.getLastName(), patient.getFirstName(), patient.getBirthDate(),
                patient.getSex(), patient.getAddress(), patient.getPhoneNumber());
    }

}
