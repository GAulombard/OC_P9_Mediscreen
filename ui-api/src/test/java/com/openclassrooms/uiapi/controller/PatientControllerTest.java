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
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * The type Patient controller test.
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoryProxyFeign historyProxyFeign;

    @MockBean
    private PatientProxyFeign patientProxyFeign;

    @MockBean
    private AssessmentProxyFeign assessmentProxyFeign;


    private static NoteDTO noteDTO1;
    private static NoteDTO noteDTO2;
    private static PatientDTO patientDTO1;
    private static List<NoteDTO> noteDTOList;

    /**
     * Sets up before each.
     */
    @BeforeEach
    public void setUpBeforeEach() {
        log.info("@BeforeEach");
        noteDTO1 = new NoteDTO(1, LocalDate.now(),"note1");
        noteDTO2 = new NoteDTO(1,LocalDate.now(),"note2");
        noteDTOList = Arrays.asList(noteDTO1,noteDTO2);
        patientDTO1 = new PatientDTO(1,"Test","Test",LocalDate.now().minusMonths(1),"M","address","0123456789");

    }

    /**
     * Test get list.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getList() throws Exception {

        Map<Integer,Integer> mapCount = new HashMap<>();
        when(historyProxyFeign.getCountNotePerPatient()).thenReturn(mapCount);

        mockMvc.perform(get("/patient/list"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get list should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getList_shouldThrowsException() throws Exception {

        when(historyProxyFeign.getCountNotePerPatient()).thenThrow(new RuntimeException());

        mockMvc.perform(get("/patient/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }

    /**
     * Test get add form.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getAddForm() throws Exception {

        mockMvc.perform(get("/patient/add"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test validate add form.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validateAddForm() throws Exception {

        doNothing().when(patientProxyFeign).validate(patientDTO1);

        mockMvc.perform(post("/patient/validate").flashAttr("patientDTO",patientDTO1))
                .andExpect(status().isFound())
                .andReturn();

    }

    /**
     * Test validate add form with invalid field.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validateAddForm_withInvalidField() throws Exception {

        doNothing().when(patientProxyFeign).validate(patientDTO1);

        mockMvc.perform(post("/patient/validate"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test validate add form should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_validateAddForm_shouldThrowsException() throws Exception {

        doThrow(new RuntimeException()).when(patientProxyFeign).validate(patientDTO1);

        mockMvc.perform(post("/patient/validate").flashAttr("patientDTO",patientDTO1))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }

    /**
     * Test get update form.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getUpdateForm() throws Exception {

        when(patientProxyFeign.getPatientById(1)).thenReturn(patientDTO1);

        mockMvc.perform(get("/patient/update/1"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get update form should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_getUpdateForm_shouldThrowsException() throws Exception {

        when(patientProxyFeign.getPatientById(1)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/patient/update/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }

    /**
     * Test update.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_update() throws Exception {

        doNothing().when(patientProxyFeign).update(1,patientDTO1);

        mockMvc.perform(post("/patient/update/1").flashAttr("patientDTO",patientDTO1))
                .andExpect(status().isFound())
                .andReturn();

    }

    /**
     * Test update with invalid field.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_update_withInvalidField() throws Exception {

        doNothing().when(patientProxyFeign).update(1,patientDTO1);

        mockMvc.perform(post("/patient/update/1"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test update should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_update_shouldThrowsException() throws Exception {

        doThrow(new RuntimeException()).when(patientProxyFeign).update(1,patientDTO1);

        mockMvc.perform(post("/patient/update/1").flashAttr("patientDTO",patientDTO1))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }

    /**
     * Test delete.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_delete() throws Exception {

        doNothing().when(patientProxyFeign).delete(1);

        mockMvc.perform(get("/patient/delete/1"))
                .andExpect(status().isFound())
                .andReturn();

    }

    /**
     * Test delete should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_delete_shouldThrowsException() throws Exception {

        doThrow(new RuntimeException()).when(patientProxyFeign).delete(1);

        mockMvc.perform(get("/patient/delete/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }

    /**
     * Test profile.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_profile() throws Exception {

        AssessmentDTO assessmentDTO = new AssessmentDTO();

        when(patientProxyFeign.getPatientById(1)).thenReturn(patientDTO1);
        when(historyProxyFeign.getAll(1)).thenReturn(noteDTOList);
        when(assessmentProxyFeign.getPatientAssessment(1)).thenReturn(assessmentDTO);

        mockMvc.perform(get("/patient/profile/1"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test profile should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    public void test_profile_shouldThrowsException() throws Exception {

        when(patientProxyFeign.getPatientById(1)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/patient/profile/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }
}
