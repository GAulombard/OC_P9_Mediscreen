package com.openclassrooms.historyapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Note counter.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteCounter {

    private Integer patient_id;
    private Integer count;

}
