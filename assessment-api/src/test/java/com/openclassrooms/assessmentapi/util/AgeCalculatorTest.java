package com.openclassrooms.assessmentapi.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@SpringBootTest
class AgeCalculatorTest {

    @Autowired
    private AgeCalculator ageCalculator;

    @Test
    void test_getAgeFromBirthDate() {

        LocalDate birthdate = LocalDate.now().minusYears(30);

        assertEquals(30, ageCalculator.getAgeFromBirthDate(birthdate));

    }

    @Test
    void test_getAgeFromBirthDate_shouldThrowsException() {

        LocalDate birthdate = LocalDate.now().plusYears(1);

        assertThrows(IllegalArgumentException.class,()->ageCalculator.getAgeFromBirthDate(birthdate));

    }

}
