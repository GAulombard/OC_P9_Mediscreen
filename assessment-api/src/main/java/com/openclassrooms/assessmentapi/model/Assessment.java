package com.openclassrooms.assessmentapi.model;

import com.openclassrooms.assessmentapi.dto.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Assessment.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assessment {

    private PatientDTO patientDTO;
    private int age;
    private String diabetesRiskLevel;

    @Override
    public String toString() {
        return "Patient: "+patientDTO.getLastName()+" "+patientDTO.getFirstName()+" (age "+age+") diabetes assessment is: "+diabetesRiskLevel;
    }
}
