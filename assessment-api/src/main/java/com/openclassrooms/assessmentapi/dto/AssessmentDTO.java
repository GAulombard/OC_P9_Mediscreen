package com.openclassrooms.assessmentapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Assessment dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDTO {

    private PatientDTO patientDTO;
    private int age;
    private String diabetesRiskLevel;

    @Override
    public String toString() {
        return "Patient: "+patientDTO.getLastName()+" "+patientDTO.getFirstName()+" (age "+age+") diabetes assessment is: "+diabetesRiskLevel;
    }
}
