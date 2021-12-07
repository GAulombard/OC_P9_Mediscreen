package com.openclassrooms.patientapi.util;

import com.openclassrooms.patientapi.dto.PatientDTO;
import com.openclassrooms.patientapi.model.Patient;
import com.openclassrooms.patientapi.service.PatientServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class DTOConverterTest {

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

    @BeforeAll
    public static void setUp() {
        log.info("@BeforeAll");
        patientDTO1 = new PatientDTO("Test1","test1", LocalDate.of(2000,12,24),"M");
        patientDTO2 = new PatientDTO("Test2","test2", LocalDate.of(2001,12,24),"F");
        patientDTOList = Arrays.asList(patientDTO1,patientDTO2);
        patient1 = new Patient("Test3","test3", LocalDate.of(2000,12,24),"M");
        patient2 = new Patient("Test4","test4", LocalDate.of(2001,12,24),"F");
        patientList = Arrays.asList(patient1,patient2);
    }

    @Test
    public void test_PatientToPatientDTO() {
        PatientDTO patientDTO = dtoConverter.PatientToPatientDTO(patient1);

        assertEquals("Test3",patientDTO.getLastName());
        assertEquals("test3",patientDTO.getFirstName());
    }

    @Test
    public void test_PatientDTOToPatient() {
        Patient patient = dtoConverter.PatientDTOToPatient(patientDTO1);

        assertEquals("Test1",patient.getLastName());
        assertEquals("test1",patient.getFirstName());
    }

}
