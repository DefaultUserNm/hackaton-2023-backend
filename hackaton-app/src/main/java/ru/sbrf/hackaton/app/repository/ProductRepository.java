package ru.sbrf.hackaton.app.repository;

import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.sbrf.hackaton.app.model.domain.entity.ProductEntity;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntity, ObjectId> {

    @Query("{id:'?0'}")
    @NotNull
    Optional<ProductEntity> findById(@NotNull ObjectId productId);
}
