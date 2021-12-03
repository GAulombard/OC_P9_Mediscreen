package com.openclassrooms.uiapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer id;

    @NotEmpty(message = "Last name is mandatory")
    @Size(min = 1,max = 50,message = "Last name must contains at least 1 letter and 50 letters maximum")
    private String lastName;

    @NotEmpty(message = "First name is mandatory")
    @Size(min = 1,max = 50,message = "First name must contains at least 1 letter and 50 letters maximum")
    private String firstName;

    @Past(message = "Birth-date must precede today's")
    @DateTimeFormat(pattern = "yyyy-MM-dd") //todo: find a way to write the right error message for this
    @NotNull(message = "Birth-date is mandatory")
    private LocalDate birthDate;

    private String sex;

    private String address;

    @Pattern(regexp="(^$|[0-9]{10})",message = "Phone number must contains only numbers, and maximum 10 numbers")
    private String phoneNumber;
}
