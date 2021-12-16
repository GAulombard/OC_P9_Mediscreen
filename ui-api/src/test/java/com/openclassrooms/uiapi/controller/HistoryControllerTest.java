package com.openclassrooms.uiapi.controller;

import com.openclassrooms.uiapi.dto.NoteDTO;
import com.openclassrooms.uiapi.dto.PatientDTO;
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
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * The type History controller test.
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class HistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoryProxyFeign historyProxyFeign;

    @MockBean
    private PatientProxyFeign patientProxyFeign;

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
        noteDTO1 = new NoteDTO(1,LocalDate.now(),"note1");
        noteDTO2 = new NoteDTO(1,LocalDate.now(),"note2");
        noteDTOList = Arrays.asList(noteDTO1,noteDTO2);
        patientDTO1 = new PatientDTO(1,"Test","Test",LocalDate.now(),"M","address","0123456789");

    }

    /**
     * Test get list.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getList() throws Exception {

        when(historyProxyFeign.getAll(1)).thenReturn(noteDTOList);

        mockMvc.perform(get("/history/list/1"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get list should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getList_shouldThrowsException() throws Exception {

        when(historyProxyFeign.getAll(1)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/history/list/1"))
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
    void test_getAddForm() throws Exception {

        when(patientProxyFeign.getPatientById(1)).thenReturn(patientDTO1);

        mockMvc.perform(get("/history/add/1"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get add form should throw exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getAddForm_shouldThrowException() throws Exception {

        when(patientProxyFeign.getPatientById(1)).thenThrow(new RuntimeException());

        mockMvc.perform(get("/history/add/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }

    /**
     * Test validate add form.
     *
     * @throws Exception the exception
     */
    @Test
    void test_validateAddForm() throws Exception {

        doNothing().when(historyProxyFeign).validate(noteDTO1);

        mockMvc.perform(post("/history/validate").flashAttr("noteDTO",noteDTO1))
                .andExpect(status().isFound())
                .andReturn();

    }

    //fixme: see why this test doesn't work

    /**
     * Test validate add form should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_validateAddForm_shouldThrowsException() throws Exception {

        doThrow(new RuntimeException()).when(historyProxyFeign).validate(noteDTO1);

        mockMvc.perform(post("/history/validate").flashAttr("noteDTO",noteDTO1))
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
    void test_getUpdateForm() throws Exception {

        when(historyProxyFeign.getNoteById(anyString())).thenReturn(noteDTO1);

        mockMvc.perform(get("/history/update/1"))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test get update form should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_getUpdateForm_shouldThrowsException() throws Exception {

        when(historyProxyFeign.getNoteById(anyString())).thenThrow(new RuntimeException());

        mockMvc.perform(get("/history/update/1"))
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
    void test_update() throws Exception {

        doNothing().when(historyProxyFeign).update("anyString",noteDTO1);

        mockMvc.perform(post("/history/update/anyString").flashAttr("noteDTO",noteDTO1))
                .andExpect(status().isFound())
                .andReturn();

    }

    /**
     * Test update should throw exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_update_shouldThrowException() throws Exception {

        doThrow(new RuntimeException()).when(historyProxyFeign).update("anyString",noteDTO1);

        mockMvc.perform(post("/history/update/anyString").flashAttr("noteDTO",noteDTO1))
                .andExpect(status().isOk())
                .andReturn();

    }

    /**
     * Test delete.
     *
     * @throws Exception the exception
     */
    @Test
    void test_delete() throws Exception {

        when(historyProxyFeign.getPatientId(anyString())).thenReturn(1);
        doNothing().when(historyProxyFeign).delete("anyString");

        mockMvc.perform(get("/history/delete/anyString"))
                .andExpect(status().isFound())
                .andReturn();

    }

    /**
     * Test delete should throws exception.
     *
     * @throws Exception the exception
     */
    @Test
    void test_delete_shouldThrowsException() throws Exception {

        when(historyProxyFeign.getPatientId(anyString())).thenThrow(new RuntimeException());
        //doNothing().when(historyProxyFeign).delete("anyString");

        mockMvc.perform(get("/history/delete/anyString"))
                .andExpect(status().isOk())
                .andExpect(view().name("error/error"))
                .andReturn();

    }

}
