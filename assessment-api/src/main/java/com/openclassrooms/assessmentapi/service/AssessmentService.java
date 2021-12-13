package com.openclassrooms.assessmentapi.service;

import com.openclassrooms.assessmentapi.model.Assessment;
import org.springframework.stereotype.Service;

@Service
public interface AssessmentService {

    Assessment getPatientAssessmentById(Integer patientId) throws Exception;
}
