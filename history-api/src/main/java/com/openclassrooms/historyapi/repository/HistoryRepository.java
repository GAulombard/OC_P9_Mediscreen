package com.openclassrooms.historyapi.repository;

import com.openclassrooms.historyapi.model.Note;
import com.openclassrooms.historyapi.model.NoteCounter;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * The interface History repository.
 */
@Repository
public interface HistoryRepository extends MongoRepository<Note, String> {

    /**
     * Find notes by patient id list.
     *
     * @param patientId the patient id
     * @return the list
     */
    List<Note> findNotesByPatientId(Integer patientId);

    /**
     * Find note by id note.
     *
     * @param id the id
     * @return the note
     */
    Note findNoteById(String id);

    /**
     * Exists by note and patient id and date boolean.
     *
     * @param note      the note
     * @param patientId the patient id
     * @param date      the date
     * @return the boolean
     */
    boolean existsByNoteAndPatientIdAndDate(String note, Integer patientId, LocalDate date);

    /**
     * Count notes per patient aggregation results.
     *
     * @return the aggregation results
     */
//group = GROUP BY in SQL: gathers input together as per the specified criteria (e.g. count, sum) to return a document for each distinct grouping
    //project = SELECT in SQL: 	selects only the required fields, can also be used to compute and add derived fields to the collection
    //varGroup = { $group : {"_id" : "$patient_id", "count" : {$sum : 1} } }
    //varProject = { $project: {"_id": 0,"patient_id":"$_id","count": 1}}
    //db.getCollection('note').aggregate([varGroup,varProject])
    @Aggregation(pipeline = {"{ $group : {\"_id\" : \"$patient_id\", \"count\" : {$sum : 1} } }","{ $project: {\"_id\": 0,\"patient_id\":\"$_id\",\"count\": 1}}"})
    AggregationResults<NoteCounter> countNotesPerPatient();

}
