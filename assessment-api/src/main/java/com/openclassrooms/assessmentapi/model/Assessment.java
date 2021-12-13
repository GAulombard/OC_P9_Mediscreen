package com.openclassrooms.assessmentapi.model;

import com.openclassrooms.assessmentapi.dto.PatientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assessment {

    private PatientDTO patientDTO;

    private String diabetesRiskLevel;

}
