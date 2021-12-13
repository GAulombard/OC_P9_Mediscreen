package com.openclassrooms.historyapi.integration;

import com.openclassrooms.historyapi.controller.HistoryController;
import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import com.openclassrooms.historyapi.service.HistoryService;
import com.openclassrooms.historyapi.util.DTOConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HistoryController.class)
public class HistoryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private DTOConverter dtoConverter;

    private NoteDTO noteDTO1;
    private NoteDTO noteDTO2;
    private List<NoteDTO> noteDTOList;


    @BeforeEach
    void setup() {
        noteDTO1 = new NoteDTO("note1id",1, LocalDate.now(),"note1");
        noteDTO2 = new NoteDTO("note2id",2, LocalDate.now(),"note2");
        noteDTOList = Arrays.asList(noteDTO1,noteDTO2);
    }

/*    @Test
    public void test_getNoteById() throws NoteNotFoundException, Exception {

        when(historyService.readById(anyString())).thenReturn(noteDTO1);

        mockMvc.perform(get("/history/dlkjdfg"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

    }*/

}
