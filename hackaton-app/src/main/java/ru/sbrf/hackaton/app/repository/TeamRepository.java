package ru.sbrf.hackaton.app.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.sbrf.hackaton.app.model.domain.entity.TeamEntity;

import java.util.Optional;


public interface TeamRepository extends MongoRepository<TeamEntity, String> {
    @Query("{id: '?0'}")
    Optional<TeamEntity> findById(ObjectId id);

    @Query("{name: '?0'}")
    Optional<TeamEntity> findByName(String name);

}
