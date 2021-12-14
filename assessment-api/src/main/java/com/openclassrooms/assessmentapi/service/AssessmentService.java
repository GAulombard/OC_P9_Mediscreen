package com.openclassrooms.assessmentapi.service;

import com.openclassrooms.assessmentapi.dto.PatientDTO;
import com.openclassrooms.assessmentapi.model.Assessment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssessmentService {

    Assessment getPatientAssessmentById(Integer patientId) throws Exception;

    List<PatientDTO> getAllPatientByFamilyName(String familyName);
}
