package com.openclassrooms.uiapi.dto;

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

    private String diabetesRiskLevel;

}
