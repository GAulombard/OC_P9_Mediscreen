package com.openclassrooms.uiapi.proxy;

import com.openclassrooms.uiapi.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "patient-api",url="${proxy.patient}")
public interface PatientProxyFeign {

    @GetMapping({"/list"})
    List<PatientDTO> getAll();

    @GetMapping({"/delete/{id}"})
    void delete(@PathVariable("id") Integer id);

}
