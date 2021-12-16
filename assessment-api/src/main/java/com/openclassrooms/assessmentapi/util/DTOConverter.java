package com.openclassrooms.assessmentapi.util;

import com.openclassrooms.assessmentapi.dto.AssessmentDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import org.springframework.stereotype.Component;

/**
 * The type Dto converter.
 */
@Component
public class DTOConverter {

    /**
     * Assessment to assessment dto assessment dto.
     *
     * @param assessment the assessment
     * @return the assessment dto
     */
    public AssessmentDTO AssessmentToAssessmentDTO(Assessment assessment) {

        return new AssessmentDTO(assessment.getPatientDTO(),assessment.getDiabetesRiskLevel());
    }
}
