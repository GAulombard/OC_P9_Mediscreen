package com.openclassrooms.assessmentapi.util;

import com.openclassrooms.assessmentapi.dto.AssessmentDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    public AssessmentDTO AssessmentToAssessmentDTO(Assessment assessment) {

        return new AssessmentDTO(assessment.getPatientDTO(),assessment.getDiabetesRiskLevel());
    }
}
