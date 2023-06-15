package ru.sbrf.hackaton.app.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.sbrf.hackaton.app.model.domain.entity.DocumentEntity;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends MongoRepository<DocumentEntity, String> {

    @Query("{id:'?0'}")
    Optional<DocumentEntity> findById(ObjectId id);

    @Query("{author:'?0'}")
    List<DocumentEntity> findByAuthor(String author);
}
