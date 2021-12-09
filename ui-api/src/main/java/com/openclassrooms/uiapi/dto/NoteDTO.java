package com.openclassrooms.uiapi.dto;

import lombok.*;

import java.time.LocalDate;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class NoteDTO {

    private String id;

    private Integer patientId;

    private LocalDate date;

    private String note;

    public NoteDTO(Integer patientId, LocalDate date, String note) {
        this.patientId = patientId;
        this.date = date;
        this.note = note;
    }
}
