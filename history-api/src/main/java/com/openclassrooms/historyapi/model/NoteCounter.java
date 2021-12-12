package com.openclassrooms.historyapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteCounter {

    private Integer patientId;
    private Integer nrbNote;

}
