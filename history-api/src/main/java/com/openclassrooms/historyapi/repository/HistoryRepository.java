package com.openclassrooms.historyapi.repository;

import com.openclassrooms.historyapi.model.Note;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface HistoryRepository extends MongoRepository<Note,String> {

    List<Note> findNotesByPatientId(Integer patientId);

    Note findNoteById(String id);

}
