package com.openclassrooms.assessmentapi.util;

import com.openclassrooms.assessmentapi.dto.AssessmentDTO;
import com.openclassrooms.assessmentapi.dto.PatientDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class DTOConverterTest {

    @Autowired
    private DTOConverter dtoConverter;

    @Test
    void test_AssessmentToAssessmentDTO() {

        Assessment assessment = new Assessment(new PatientDTO("Test","test", LocalDate.now(),"M"),"None");

        AssessmentDTO assessmentDTO = dtoConverter.AssessmentToAssessmentDTO(assessment);

        assertEquals("Test",assessmentDTO.getPatientDTO().getLastName());
        assertEquals("None",assessmentDTO.getDiabetesRiskLevel());

    }
}
