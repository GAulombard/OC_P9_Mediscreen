package com.openclassrooms.patientapi;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.exception.PatientAlreadyExistsException;
import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.service.PatientServiceImp;
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

@SpringBootTest
@Slf4j
public class PatientServiceTest {

    @Autowired
    private JpaRepository patientRepository;

    @Autowired
    private PatientServiceImp patientServiceImp;

    private static PatientDTO patientDTO1;
    private static PatientDTO patientDTO2;
    private static Patient patient1;
    private static Patient patient2;
    private static List<Patient> patientList;
    private static List<PatientDTO> patientDTOList;

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

    @Test
    @Transactional
    @Rollback
    public void test_getAll() throws PatientAlreadyExistsException {
        patientServiceImp.save(patientDTO1);
        patientServiceImp.save(patientDTO2);

        assertEquals(2,patientServiceImp.getAll().size());

    }

    @Test
    @Transactional
    @Rollback
    public void test_getAll_shouldThrowPatientAlreadyExistsException() throws PatientAlreadyExistsException {
        patientServiceImp.save(patientDTO1);

        assertThrows(PatientAlreadyExistsException.class,() -> patientServiceImp.save(patientDTO1));

    }
}
