package com.openclassrooms.uiapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer id;

    @NotEmpty(message = "Last name is mandatory")
    @Length(max = 125, message = "The maximum length for lastName is 125 characters")
    private String lastName;

    @NotEmpty(message = "First name is mandatory")
    @Length(max = 125, message = "The maximum length for firstName is 125 characters")
    private String firstName;

    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Please enter a valid birth date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotEmpty(message = "Sex is mandatory")
    @Length(max = 1, message = "The maximum length for sex is 1 characters")
    @Pattern(regexp = "^[M|F]{1}$", message = "Please enter character M or F")
    private String sex;

    @Length(max = 150, message = "The maximum length for address is 150 characters")
    private String address;

    @Length(max = 10, message = "Please enter a valid phone number")
    private String phoneNumber;
}
