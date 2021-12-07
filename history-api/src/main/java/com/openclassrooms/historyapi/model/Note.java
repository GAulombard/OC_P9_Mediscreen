package com.openclassrooms.historyapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private String id;

    private Integer patientId;

    private LocalDate date;

    private String note;

    public Note(Integer patientId, LocalDate date, String note) {
        this.patientId = patientId;
        this.date = date;
        this.note = note;
    }
}
