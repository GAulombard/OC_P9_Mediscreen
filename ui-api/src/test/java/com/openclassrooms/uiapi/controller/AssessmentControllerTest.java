package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.AssessmentDTO;
import com.openclassrooms.uiapi.dto.NoteDTO;
import com.openclassrooms.uiapi.dto.PatientDTO;
import com.openclassrooms.uiapi.proxy.AssessmentProxyFeign;
import com.openclassrooms.uiapi.proxy.HistoryProxyFeign;
import com.openclassrooms.uiapi.proxy.PatientProxyFeign;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
    private AssessmentProxyFeign assessmentProxyFeign;

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

        PatientDTO  patientDTO = new PatientDTO(12,"TEST","test",LocalDate.now(),"M","address","0123456789");
        AssessmentDTO assessmentDTO = new AssessmentDTO(patientDTO,0,"test");

        when(assessmentProxyFeign.getPatientAssessment(1)).thenReturn(assessmentDTO);

        mockMvc.perform(get("/assessment/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    /**
     * Test get patient assessment should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getPatientAssessment_shouldThrowsException() throws Exception {

        when(assessmentProxyFeign.getPatientAssessment(1)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/assessment/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();
    }

    /**
     * Test get family assessment.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getFamilyAssessment() throws Exception {

        List<AssessmentDTO> assessmentDTOList = new ArrayList<>();

        when(assessmentProxyFeign.getFamilyAssessment("anyString")).thenReturn(assessmentDTOList);

        mockMvc.perform(get("/assessment/familyName?value=anyString"))
                .andExpect(status().isOk())
                .andReturn();
    }

    /**
     * Test get family assessment should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getFamilyAssessment_shouldThrowsException() throws Exception {

        when(assessmentProxyFeign.getFamilyAssessment("anyString")).thenThrow(new RuntimeException());

        mockMvc.perform(get("/assessment/familyName?value=anyString"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();
    }

}
