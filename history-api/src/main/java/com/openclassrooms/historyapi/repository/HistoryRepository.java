package com.openclassrooms.historyapi.repository;

import com.openclassrooms.historyapi.model.Note;
import com.openclassrooms.historyapi.model.NoteCounter;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistoryRepository extends MongoRepository<Note, String> {

    List<Note> findNotesByPatientId(Integer patientId);

    Note findNoteById(String id);

    boolean existsByNoteAndPatientIdAndDate(String note, Integer patientId, LocalDate date);

    //group = GROUP BY in SQL: gathers input together as per the specified criteria (e.g. count, sum) to return a document for each distinct grouping
    //project = SELECT in SQL: 	selects only the required fields, can also be used to compute and add derived fields to the collection
    @Aggregation(pipeline = {
            "  { $group : { "
                    + "      _id: \"$patient_id\","
                    + "      count : { $sum : 1 }"
                    + "     }"
                    + "  }"
            ,
            "  { $project: {"
                    + "      _id: 0,"
                    + "      patient_id: \"$_id\","
                    + "      count: 1"
                    + "    }"
                    + "  }"
    })
    AggregationResults<NoteCounter> countNotesPerPatient();

}
