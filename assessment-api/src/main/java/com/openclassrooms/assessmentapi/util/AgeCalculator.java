package com.openclassrooms.assessmentapi.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Slf4j
@Component
public class AgeCalculator {

    public int getAgeFromBirthDate(LocalDate birthDate) {

        int age = Period.between(birthDate, LocalDate.now()).getDays();

        if(birthDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("ERROR: Birthdate can't after today's date");

        return age;
    }

}
