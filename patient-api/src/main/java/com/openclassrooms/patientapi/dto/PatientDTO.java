package com.openclassrooms.patientapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

/**
 * The type Patient dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Integer id;

    private String lastName;

    private String firstName;

    private LocalDate birthDate;

    private String sex;

    private String address;

    private String phoneNumber;

    /**
     * Instantiates a new Patient dto.
     *
     * @param lastName  the last name
     * @param firstName the first name
     * @param birthDate the birth date
     * @param sex       the sex
     */
    public PatientDTO(String lastName, String firstName, LocalDate birthDate, String sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.sex = sex;
    }
}
