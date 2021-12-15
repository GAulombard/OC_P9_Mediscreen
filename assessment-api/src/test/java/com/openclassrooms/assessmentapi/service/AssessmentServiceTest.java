package com.openclassrooms.assessmentapi.service;

import com.openclassrooms.assessmentapi.dto.NoteDTO;
import com.openclassrooms.assessmentapi.dto.PatientDTO;
import com.openclassrooms.assessmentapi.proxy.HistoryProxyFeign;
import com.openclassrooms.assessmentapi.proxy.PatientProxyFeign;
import com.openclassrooms.assessmentapi.util.AgeCalculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
@Slf4j
class AssessmentServiceTest {

    @Mock
    private PatientProxyFeign patientProxyFeign;

    @Mock
    private HistoryProxyFeign historyProxyFeign;

    @Mock
    private AgeCalculator ageCalculator;

    @InjectMocks
    private AssessmentServiceImp assessmentService;

    @Test
    void test_getPatientAssessmentById() throws Exception {
        PatientDTO patientDTO = new PatientDTO(1,"Test","test", LocalDate.now(),"M","address","0123456789");
        List<NoteDTO> noteDTOList = Arrays.asList(new NoteDTO("anyString",1,LocalDate.now(),"note"));

        when(patientProxyFeign.getPatientById(1)).thenReturn(patientDTO);
        when(historyProxyFeign.getAll(1)).thenReturn(noteDTOList);
        when(ageCalculator.getAgeFromBirthDate(any(LocalDate.class))).thenReturn(1);

        assertEquals(1,assessmentService.getPatientAssessmentById(1).getPatientDTO().getId());
        assertEquals("None",assessmentService.getPatientAssessmentById(1).getDiabetesRiskLevel());
    }

    @Test
    void test_getPatientAssessmentById_shouldThrowException() {

        when(patientProxyFeign.getPatientById(1)).thenThrow(new RuntimeException());

        assertThrows(Exception.class,()->assessmentService.getPatientAssessmentById(1));

    }

    @Test
    void test_getAllPatientByFamilyName(){
        PatientDTO patientDTO = new PatientDTO(1,"Test","test", LocalDate.now(),"M","address","0123456789");
        List<PatientDTO> patientDTOList = Arrays.asList(patientDTO);

        when(patientProxyFeign.getAllByLastName("Test")).thenReturn(patientDTOList);

        assertEquals(1,assessmentService.getAllPatientByFamilyName("Test").size());

    }

    @Test
    void test_getPatientAssessmentById_withHeightTrigger() throws Exception {
        PatientDTO patientDTO = new PatientDTO(1,"Test","test", LocalDate.now(),"M","address","0123456789");
        NoteDTO noteDTO1 = new NoteDTO("anyString",1,LocalDate.now(),"Hemoglobin A1C");
        NoteDTO noteDTO2 = new NoteDTO("anyString",1,LocalDate.now(),"Microalbumin");
        NoteDTO noteDTO3 = new NoteDTO("anyString",1,LocalDate.now(),"Height");
        NoteDTO noteDTO4 = new NoteDTO("anyString",1,LocalDate.now(),"Weight");
        NoteDTO noteDTO5 = new NoteDTO("anyString",1,LocalDate.now(),"Smoker");
        NoteDTO noteDTO6 = new NoteDTO("anyString",1,LocalDate.now(),"Abnormal");
        NoteDTO noteDTO7 = new NoteDTO("anyString",1,LocalDate.now(),"Dizziness");
        NoteDTO noteDTO8 = new NoteDTO("anyString",1,LocalDate.now(),"Relapse");
        List<NoteDTO> noteDTOList = Arrays.asList(noteDTO1,noteDTO2,noteDTO3,noteDTO4,noteDTO5,noteDTO6,noteDTO7,noteDTO8);

        when(patientProxyFeign.getPatientById(1)).thenReturn(patientDTO);
        when(historyProxyFeign.getAll(1)).thenReturn(noteDTOList);
        when(ageCalculator.getAgeFromBirthDate(any(LocalDate.class))).thenReturn(1);

        assertEquals(1,assessmentService.getPatientAssessmentById(1).getPatientDTO().getId());
        assertEquals("Early onset",assessmentService.getPatientAssessmentById(1).getDiabetesRiskLevel());
    }

    @Test
    void test_getPatientAssessmentById_withThreeTrigger() throws Exception {
        PatientDTO patientDTO = new PatientDTO(1,"Test","test", LocalDate.now(),"M","address","0123456789");
        NoteDTO noteDTO3 = new NoteDTO("anyString",1,LocalDate.now(),"Height");
        NoteDTO noteDTO4 = new NoteDTO("anyString",1,LocalDate.now(),"Weight");
        NoteDTO noteDTO5 = new NoteDTO("anyString",1,LocalDate.now(),"Smoker");
        List<NoteDTO> noteDTOList = Arrays.asList(noteDTO3,noteDTO4,noteDTO5);

        when(patientProxyFeign.getPatientById(1)).thenReturn(patientDTO);
        when(historyProxyFeign.getAll(1)).thenReturn(noteDTOList);
        when(ageCalculator.getAgeFromBirthDate(any(LocalDate.class))).thenReturn(1);

        assertEquals(1,assessmentService.getPatientAssessmentById(1).getPatientDTO().getId());
        assertEquals("In danger",assessmentService.getPatientAssessmentById(1).getDiabetesRiskLevel());
    }

    @Test
    void test_getPatientAssessmentById_withTwoTriggerAndMoreThanThirtyYearsOld() throws Exception {
        PatientDTO patientDTO = new PatientDTO(1,"Test","test", LocalDate.now(),"M","address","0123456789");
        NoteDTO noteDTO1 = new NoteDTO("anyString",1,LocalDate.now(),"Hemoglobin A1C");
        NoteDTO noteDTO2 = new NoteDTO("anyString",1,LocalDate.now(),"Microalbumin");
        List<NoteDTO> noteDTOList = Arrays.asList(noteDTO1,noteDTO2);

        when(patientProxyFeign.getPatientById(1)).thenReturn(patientDTO);
        when(historyProxyFeign.getAll(1)).thenReturn(noteDTOList);
        when(ageCalculator.getAgeFromBirthDate(any(LocalDate.class))).thenReturn(40);

        assertEquals(1,assessmentService.getPatientAssessmentById(1).getPatientDTO().getId());
        assertEquals("Borderline",assessmentService.getPatientAssessmentById(1).getDiabetesRiskLevel());
    }
    

}
