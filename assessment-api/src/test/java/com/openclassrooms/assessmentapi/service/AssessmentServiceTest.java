package com.openclassrooms.assessmentapi.service;

import com.openclassrooms.assessmentapi.proxy.HistoryProxyFeign;
import com.openclassrooms.assessmentapi.proxy.PatientProxyFeign;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
@Slf4j
public class AssessmentServiceTest {

    @Autowired
    private PatientProxyFeign patientProxyFeign;

    @Autowired
    private HistoryProxyFeign historyProxyFeign;

    @Autowired
    private AssessmentServiceImp assessmentService;

    @Test
    public void test_getPatientAssessmentById_shouldThrowsException(){

        assertThrows(Exception.class, () -> assessmentService.getPatientAssessmentById(120000));

    }
}
