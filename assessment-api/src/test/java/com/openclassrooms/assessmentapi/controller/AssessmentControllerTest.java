package com.openclassrooms.assessmentapi.controller;

import com.openclassrooms.assessmentapi.dto.AssessmentDTO;
import com.openclassrooms.assessmentapi.dto.PatientDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import com.openclassrooms.assessmentapi.service.AssessmentServiceImp;
import com.openclassrooms.assessmentapi.util.DTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Assessment controller test.
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class AssessmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssessmentServiceImp assessmentService;

    @MockBean
    private DTOConverter dtoConverter;

    /**
     * Sets up.
     */
    @BeforeAll
    static void setUp() {
        log.info("@BeforeAll");
    }

    /**
     * Sets up before each.
     */
    @BeforeEach
    public void setUpBeforeEach() {
        log.info("@BeforeEach");
    }

    /**
     * Test get patient assessment.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getPatientAssessment() throws Exception {

        Assessment assessment3 = new Assessment(new PatientDTO(),25,"None");
        AssessmentDTO assessmentDTO3 = new AssessmentDTO(new PatientDTO(),25,"None");
        when(assessmentService.getPatientAssessmentById(anyInt())).thenReturn(assessment3);
        when(dtoConverter.AssessmentToAssessmentDTO(assessment3)).thenReturn(assessmentDTO3);

        MvcResult mvcResult = mockMvc.perform(get("/assessment/1"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("None");

    }


    /**
     * Test get family assessment list.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getFamilyAssessmentList() throws Exception {

        PatientDTO patientDTO = new PatientDTO(1,"ferguson","Lucas", LocalDate.now(),"M","address","0123456789");
        PatientDTO patientDTO2 = new PatientDTO(2,"ferguson","Dude", LocalDate.now(),"M","address","0123456789");
        List<PatientDTO> patientDTOList = Arrays.asList(patientDTO,patientDTO2);
        Assessment assessment = new Assessment(patientDTO,25,"test");
        Assessment assessment2 = new Assessment(patientDTO2,25,"test");
        AssessmentDTO assessmentDTO = new AssessmentDTO(patientDTO,25,"test");
        AssessmentDTO assessment2DTO = new AssessmentDTO(patientDTO2,25,"test");


        when(assessmentService.getAllPatientByFamilyName("ferguson")).thenReturn(patientDTOList);
        when(assessmentService.getPatientAssessmentById(1)).thenReturn(assessment);
        when(assessmentService.getPatientAssessmentById(2)).thenReturn(assessment2);
        when(dtoConverter.AssessmentToAssessmentDTO(assessment)).thenReturn(assessmentDTO);
        when(dtoConverter.AssessmentToAssessmentDTO(assessment2)).thenReturn(assessment2DTO);

        MvcResult mvcResult = mockMvc.perform(get("/assessment/familyName?value=ferguson"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("Dude").contains("Lucas");

    }

}
