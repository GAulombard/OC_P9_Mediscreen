package com.openclassrooms.patientapi.service;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.exception.PatientAlreadyExistsException;
import com.openclassrooms.patientapi.exception.PatientNotFoundException;
import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.service.PatientServiceImp;
import com.openclassrooms.patientapi.util.DTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The type Patient service test.
 */
@SpringBootTest
@Slf4j
public class PatientServiceTest {

    @Autowired
    private JpaRepository patientRepository;

    @Autowired
    private DTOConverter dtoConverter;

    @Autowired
    private PatientServiceImp patientServiceImp;

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
    public static void setUp() {
        log.info("@BeforeAll");
        patientDTO1 = new PatientDTO("Test1","test1", LocalDate.of(2000,12,24),"M");
        patientDTO2 = new PatientDTO("Test2","test2", LocalDate.of(2001,12,24),"F");
        patientDTOList = Arrays.asList(patientDTO1,patientDTO2);
        patient1 = new Patient();
        patient2 = new Patient();
        patientList = Arrays.asList(patient1,patient2);
    }

    /**
     * Test get all.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_getAll() throws PatientAlreadyExistsException {
        patientServiceImp.save(patientDTO1);
        patientServiceImp.save(patientDTO2);

        assertEquals(2,patientServiceImp.getAll().size());

    }

    /**
     * Test get all by last name.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_getAllByLastName() throws PatientAlreadyExistsException {
        patientServiceImp.save(patientDTO1);

        assertEquals(1,patientServiceImp.getAllByLastName(patientDTO1.getLastName()).size());

    }

    /**
     * Test save.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_save() throws PatientAlreadyExistsException {
        patientServiceImp.save(patientDTO1);
        List<Patient> patientList = patientServiceImp.getAll();
        Patient patient = patientList.get(0);

        assertEquals(1,patientServiceImp.getAll().size());
        assertEquals("Test1",patient.getLastName());
        assertEquals("test1",patient.getFirstName());

    }

    /**
     * Test save should throws patient already exists exception.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_save_shouldThrowsPatientAlreadyExistsException() throws PatientAlreadyExistsException {
        patientServiceImp.save(patientDTO1);

        assertThrows(PatientAlreadyExistsException.class,() -> patientServiceImp.save(patientDTO1));

    }

    /**
     * Test delete.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     * @throws PatientNotFoundException      the patient not found exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_delete() throws PatientAlreadyExistsException, PatientNotFoundException {
        patientServiceImp.save(patientDTO1);

        List<Patient> patientList = patientServiceImp.getAll();

        Patient patient = patientList.get(0);

        patientServiceImp.delete(patient.getId());

        assertEquals(0,patientServiceImp.getAll().size());

    }

    /**
     * Test delete should throws patient not found exception.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     * @throws PatientNotFoundException      the patient not found exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_delete_shouldThrowsPatientNotFoundException() throws PatientAlreadyExistsException, PatientNotFoundException {

        assertThrows(PatientNotFoundException.class,() -> patientServiceImp.delete(150));

    }

    /**
     * Test update.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     * @throws PatientNotFoundException      the patient not found exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_update() throws PatientAlreadyExistsException, PatientNotFoundException {
        patientServiceImp.save(patientDTO1);
        List<Patient> patientList = patientServiceImp.getAll();
        Patient patient = patientList.get(0);

        patient.setFirstName("John");
        patient.setLastName("Doe");

        PatientDTO newPatientDTO = dtoConverter.PatientToPatientDTO(patient);
        patientServiceImp.update(newPatientDTO);

        List<Patient> newPatientList = patientServiceImp.getAll();
        Patient newPatient = newPatientList.get(0);

        assertEquals("John",newPatient.getFirstName());
        assertEquals("Doe",newPatient.getLastName());

    }

    /**
     * Test update should throws patient not found exception.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_update_shouldThrowsPatientNotFoundException() throws PatientAlreadyExistsException {
        patientServiceImp.save(patientDTO1);
        List<Patient> patientList = patientServiceImp.getAll();
        Patient patient = patientList.get(0);

        patient.setFirstName("John");
        patient.setLastName("Doe");

        PatientDTO newPatientDTO = dtoConverter.PatientToPatientDTO(patient);
        patientDTO2.setId(150);

        assertThrows(PatientNotFoundException.class, ()-> patientServiceImp.update(patientDTO2));

    }

    /**
     * Test find patient by id.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     * @throws PatientNotFoundException      the patient not found exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_findPatientById() throws PatientAlreadyExistsException, PatientNotFoundException {

        patientServiceImp.save(patientDTO1);

        List<Patient> patientList = patientServiceImp.getAll();

        Patient patient = patientList.get(0);

        assertEquals("test1",patientServiceImp.findPatientById(patient.getId()).getFirstName());
        assertEquals("Test1",patientServiceImp.findPatientById(patient.getId()).getLastName());

    }

    /**
     * Test find patient by id should throws patient not found exception.
     *
     * @throws PatientAlreadyExistsException the patient already exists exception
     */
    @Test
    @Transactional
    @Rollback
    public void test_findPatientById_shouldThrowsPatientNotFoundException() throws PatientAlreadyExistsException {

        patientServiceImp.save(patientDTO1);

        List<Patient> patientList = patientServiceImp.getAll();

        Patient patient = patientList.get(0);

        assertThrows(PatientNotFoundException.class, ()->patientServiceImp.findPatientById(150));

    }
}
