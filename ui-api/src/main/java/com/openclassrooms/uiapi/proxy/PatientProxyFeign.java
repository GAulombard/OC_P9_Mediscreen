package com.openclassrooms.uiapi.proxy;

import com.openclassrooms.uiapi.DTO.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "patient-api",url="${proxy.patient}")
public interface PatientProxyFeign {

    @GetMapping({"/list"})
    List<PatientDTO> getAll();

}
