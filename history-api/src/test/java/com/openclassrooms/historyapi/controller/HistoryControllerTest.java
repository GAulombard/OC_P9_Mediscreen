package com.openclassrooms.historyapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteAlreadyExistsException;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import com.openclassrooms.historyapi.model.Note;
import com.openclassrooms.historyapi.repository.HistoryRepository;
import com.openclassrooms.historyapi.service.HistoryServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(HistoryController.class)
public class HistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoryServiceImp historyServiceImp;

    @MockBean
    private HistoryRepository historyRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    private static NoteDTO noteDTO1;
    private static NoteDTO noteDTO2;
    private static List<NoteDTO> noteDTOList;
    private static Note note1;
    private static Note note2;
    private static List<Note> noteList;

    @BeforeAll
    static void setUp() {
        log.info("@BeforeAll");
        noteDTO1 = new NoteDTO(1, LocalDate.now(), "note1");
        noteDTO2 = new NoteDTO(2, LocalDate.now(), "note2");
        noteDTOList = Arrays.asList(noteDTO1, noteDTO2);
        note1 = new Note(1, LocalDate.now(), "note1");
        note2 = new Note(2, LocalDate.now(), "note2");
        noteList = Arrays.asList(note1, note2);
    }

    @BeforeEach
    public void setUpBeforeEach() {
        log.info("@BeforeEach");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test_getNoteById() throws NoteNotFoundException, Exception {

        when(historyServiceImp.readById(anyString())).thenReturn(noteDTO1);

        MvcResult mvcResult = mockMvc.perform(get("/history/anyString"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assertThat(content).contains("note1");
        verify(historyServiceImp).readById("anyString");

    }

    @Test
    public void test_getAll() throws Exception {

        when(historyServiceImp.readAllByPatientId(anyInt())).thenReturn(noteDTOList);

        MvcResult mvcResult = mockMvc.perform(get("/history/list/1"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        verify(historyServiceImp).readAllByPatientId(1);

    }

    @Test
    public void test_delete() throws NoteNotFoundException, Exception {

        MvcResult mvcResult = mockMvc.perform(get("/history/delete/string"))
                .andExpect(status().isOk())
                .andReturn();

        verify(historyServiceImp).deleteById("string");

    }

    @Test
    public void test_validate() throws NoteAlreadyExistsException, Exception {
        NoteDTO noteDTO = new NoteDTO(10, LocalDate.now(), "note");

        MvcResult mvcResult = mockMvc.perform(post("/history/validate/")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(noteDTO)))
                                    .andExpect(status().isCreated())
                                    .andReturn();

    }

    @Test
    public void test_update() throws Exception, NoteAlreadyExistsException {

        NoteDTO noteDTO = new NoteDTO(10, LocalDate.now(), "note");
        historyServiceImp.create(noteDTO);
        noteDTO.setNote("note updated");

        MvcResult mvcResult = mockMvc.perform(post("/history/update/" + noteDTO.getId())
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .content(objectMapper.writeValueAsString(noteDTO)))
                                     .andExpect(status().isCreated())
                                     .andReturn();
    }

    @Test
    public void test_getPatientId() throws Exception, NoteNotFoundException {

        when(historyServiceImp.findPatientIdByNoteId(anyString())).thenReturn(anyInt());

        MvcResult mvcResult = mockMvc.perform(get("/history/patient/anyString"))
                .andExpect(status().isOk())
                .andReturn();

        verify(historyServiceImp).findPatientIdByNoteId("anyString");

    }

    @Test
    public void test_getCountNotePerPatient() throws Exception {

        Map<Integer, Integer> map = new HashMap<>();

        when(historyServiceImp.countNotesPerPatient()).thenReturn(map);

        MvcResult mvcResult = mockMvc.perform(get("/history/count"))
                .andExpect(status().isOk())
                .andReturn();

        verify(historyServiceImp).countNotesPerPatient();

    }

}
