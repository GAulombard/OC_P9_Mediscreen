package com.openclassrooms.patientapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Patient.
 */
@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "date_of_birth")
    private LocalDate birthDate;

    private String sex;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Instantiates a new Patient.
     *
     * @param lastName  the last name
     * @param firstName the first name
     * @param birthDate the birth date
     * @param sex       the sex
     */
    public Patient(String lastName, String firstName, LocalDate birthDate, String sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.sex = sex;
    }

}
