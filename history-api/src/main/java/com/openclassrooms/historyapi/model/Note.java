package com.openclassrooms.historyapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Document(collection = "note")
public class Note {

    @Id
    private String id;

    @Field(value = "patient_id")
    private Integer patientId;

    private LocalDate date;

    private String note;

    public Note(Integer patientId, LocalDate date, String note) {
        this.patientId = patientId;
        this.date = date;
        this.note = note;
    }
}
