package com.openclassrooms.historyapi.repository;

import com.openclassrooms.historyapi.model.Note;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface HistoryRepository extends MongoRepository<Note,String> {

}
