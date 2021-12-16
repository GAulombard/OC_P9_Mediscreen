package com.openclassrooms.historyapi.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * The type Note dto.
 */
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class NoteDTO {

    private String id;

    private Integer patientId;

    private LocalDate date;

    private String note;

    /**
     * Instantiates a new Note dto.
     *
     * @param patientId the patient id
     * @param date      the date
     * @param note      the note
     */
    public NoteDTO(Integer patientId, LocalDate date, String note) {
        this.patientId = patientId;
        this.date = date;
        this.note = note;
    }
}
