package com.openclassrooms.patientapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.exception.PatientAlreadyExistsException;
import com.openclassrooms.patientapi.exception.PatientNotFoundException;
import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.repository.PatientRepository;
import com.openclassrooms.patientapi.service.PatientServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Patient controller test.
 */
@Slf4j
@WebMvcTest(PatientController.class)
public class PatientControllerTest {
    //todo:Write tests for exception, and validations form

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private PatientServiceImp patientServiceImp;

    @Autowired
    private ObjectMapper objectMapper;

    private static PatientDTO patientDTO1;
    private static PatientDTO patientDTO2;
    private static Patient patient1;
    private static Patient patient2;
    private static List<Patient> patientList;
    private static List<PatientDTO> patientDTOList;

    /**
     * Sets up.
     */
    @BeforeAll
    static void setUp() {
        log.info("@BeforeAll");
        patientDTO1 = new PatientDTO("Test1", "test1", LocalDate.of(2000, 12, 24), "M");
        patientDTO2 = new PatientDTO("Test2", "test2", LocalDate.of(2001, 12, 24), "F");
        patientDTOList = Arrays.asList(patientDTO1, patientDTO2);
        patient1 = new Patient("Test1", "test1", LocalDate.of(2000, 12, 24), "M");
        patient2 = new Patient("Test2", "test2", LocalDate.of(2001, 12, 24), "F");
        patientList = Arrays.asList(patient1, patient2);
    }

    /**
     * Test get all.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getAll() throws Exception {

        when(patientServiceImp.getAll()).thenReturn(patientList);

        mockMvc.perform(get("/patient/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get patient by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getPatientById() throws Exception {

        when(patientServiceImp.findPatientById(1)).thenReturn(patientDTO1);

        mockMvc.perform(get("/patient/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get all by last name.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getAllByLastName() throws Exception {

        when(patientServiceImp.getAllByLastName(anyString())).thenReturn(patientDTOList);

        mockMvc.perform(get("/patient/list/anyString"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get patient by id should throws patient not found exception.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getPatientById_shouldThrowsPatientNotFoundException() throws Exception {

        when(patientRepository.existsById(1)).thenReturn(false);
        when(patientServiceImp.findPatientById(1)).thenThrow(PatientNotFoundException.class);

        mockMvc.perform(get("/patient/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();

    }

    /**
     * Test delete.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_delete() throws Exception {

        when(patientRepository.existsById(1)).thenReturn(true);

        mockMvc.perform(get("/patient/delete/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(patientServiceImp).delete(1);

    }

    /**
     * Test validate.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validate() throws Exception {

        when(patientRepository.existsByLastNameAndFirstNameAndBirthDate(anyString(),anyString(),any())).thenReturn(false);

        mockMvc.perform(post("/patient/validate")
                .content(objectMapper.writeValueAsString(patientDTO1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

    }


    /**
     * Test update.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_update() throws Exception {

        when(patientRepository.existsById(anyInt())).thenReturn(true);

        mockMvc.perform(post("/patient/update/1")
                        .content(objectMapper.writeValueAsString(patientDTO1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

    }



}
