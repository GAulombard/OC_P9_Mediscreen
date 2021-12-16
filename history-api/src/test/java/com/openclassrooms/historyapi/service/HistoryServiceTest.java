package com.openclassrooms.historyapi.service;

import com.openclassrooms.historyapi.dto.NoteDTO;
import com.openclassrooms.historyapi.exception.NoteAlreadyExistsException;
import com.openclassrooms.historyapi.exception.NoteNotFoundException;
import com.openclassrooms.historyapi.model.Note;
import com.openclassrooms.historyapi.repository.HistoryRepository;
import com.openclassrooms.historyapi.util.DTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * The type History service test.
 */
@SpringBootTest
@Slf4j
class HistoryServiceTest {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private DTOConverter dtoConverter;

    @Autowired
    private HistoryService historyService;

    private static NoteDTO noteDTO1;
    private static NoteDTO noteDTO2;
    private static List<NoteDTO> noteDTOList;
    private static Note note1;
    private static Note note2;
    private static List<Note> noteList;

    /**
     * Sets up.
     */
    @BeforeAll
    static void setUp() {
        log.info("@BeforeAll");
        noteDTO1 = new NoteDTO("1",1, LocalDate.now(),"note1");
        noteDTO2 = new NoteDTO("2",2,LocalDate.now(),"note2");
        noteDTOList = Arrays.asList(noteDTO1,noteDTO2);
        note1 = new Note("1",1,LocalDate.now(),"note1");
        note2 = new Note("2",2,LocalDate.now(),"note2");
        noteList = Arrays.asList(note1,note2);
    }

    /**
     * Test read by id.
     *
     * @throws NoteNotFoundException      the note not found exception
     * @throws NoteAlreadyExistsException the note already exists exception
     */
    @Test
    void test_readById() throws NoteNotFoundException, NoteAlreadyExistsException {

        historyService.create(noteDTO1);

        NoteDTO note = historyService.readById("1");

        assertThat(note.getNote()).contains("note1");

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");

    }

    /**
     * Test read by id should throws note not found exception.
     */
    @Test
    void test_readById_shouldThrowsNoteNotFoundException() {

        assertThrows(NoteNotFoundException.class, () -> historyService.readById("1"));

    }

    /**
     * Test create.
     *
     * @throws NoteAlreadyExistsException the note already exists exception
     * @throws NoteNotFoundException      the note not found exception
     */
    @Test
    void test_create() throws NoteAlreadyExistsException, NoteNotFoundException {

        historyService.create(noteDTO1);
        historyService.create(noteDTO2);

        assertEquals(2, historyRepository.findAll().size());

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");
        historyService.deleteById("2");
    }

    /**
     * Test create should throws note already exists exception.
     *
     * @throws NoteAlreadyExistsException the note already exists exception
     * @throws NoteNotFoundException      the note not found exception
     */
    @Test
    void test_create_shouldThrowsNoteAlreadyExistsException() throws NoteAlreadyExistsException, NoteNotFoundException {

        historyService.create(noteDTO1);

        assertThrows(NoteAlreadyExistsException.class, () -> historyService.create(noteDTO1));

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");

    }

    /**
     * Test update.
     *
     * @throws NoteAlreadyExistsException the note already exists exception
     * @throws NoteNotFoundException      the note not found exception
     */
    @Test
    void test_update() throws NoteAlreadyExistsException, NoteNotFoundException {

        historyService.create(noteDTO1);
        noteDTO1.setNote("note updated");
        historyService.update("1",noteDTO1);

        assertEquals("note updated", historyRepository.findNoteById("1").getNote());

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");

    }

    /**
     * Test update should throws note not found exception.
     */
    @Test
    void test_update_shouldThrowsNoteNotFoundException() {

        assertThrows(NoteNotFoundException.class, () -> historyService.update("1",noteDTO1));

    }

    /**
     * Test delete by id.
     *
     * @throws NoteAlreadyExistsException the note already exists exception
     * @throws NoteNotFoundException      the note not found exception
     */
    @Test
    void test_deleteById() throws NoteAlreadyExistsException, NoteNotFoundException {

        historyService.create(noteDTO1);

        assertEquals(1, historyRepository.findAll().size());

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");

        assertEquals(0, historyRepository.findAll().size());
    }

    /**
     * Test delete should throws note not found exception.
     */
    @Test
    void test_delete_shouldThrowsNoteNotFoundException() {

        assertThrows(NoteNotFoundException.class, () -> historyService.deleteById("1"));

    }

    /**
     * Test read all by patient id.
     *
     * @throws NoteNotFoundException      the note not found exception
     * @throws NoteAlreadyExistsException the note already exists exception
     */
    @Test
    void test_readAllByPatientId() throws NoteNotFoundException, NoteAlreadyExistsException {

        historyService.create(noteDTO1);
        NoteDTO noteDTO3 = new NoteDTO("3",1, LocalDate.now().minusDays(1),"note3");
        historyService.create(noteDTO3);

        List<NoteDTO> noteList = historyService.readAllByPatientId(1);

        assertEquals(2,noteList.size());

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");
        historyService.deleteById("3");

    }

    /**
     * Test find patient id by note id.
     *
     * @throws NoteNotFoundException      the note not found exception
     * @throws NoteAlreadyExistsException the note already exists exception
     */
    @Test
    void test_findPatientIdByNoteId() throws NoteNotFoundException, NoteAlreadyExistsException {

        historyService.create(noteDTO1);

        int patientId = historyService.findPatientIdByNoteId("1");

        assertEquals(1,patientId);

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");

    }

    /**
     * Test find patient id by note id should throws note not found exception.
     */
    @Test
    void test_findPatientIdByNoteId_shouldThrowsNoteNotFoundException() {

        assertThrows(NoteNotFoundException.class, () -> historyService.findPatientIdByNoteId("1"));

    }

    /**
     * Test count notes per patient.
     *
     * @throws NoteAlreadyExistsException the note already exists exception
     * @throws NoteNotFoundException      the note not found exception
     */
    @Test
    void test_countNotesPerPatient() throws NoteAlreadyExistsException, NoteNotFoundException {
        historyService.create(noteDTO1);
        NoteDTO noteDTO3 = new NoteDTO("3",1, LocalDate.now().minusDays(1),"note3");
        historyService.create(noteDTO3);

        Map<Integer,Integer> countMap = historyService.countNotesPerPatient();

        assertEquals(2,countMap.get(1));

        //Mongo DB doesn't support transactional action and rollback, then need to do it by hand
        historyService.deleteById("1");
        historyService.deleteById("3");
    }

}
