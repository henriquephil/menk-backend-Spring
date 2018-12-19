package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.CompraItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraItemRepository extends MongoRepository<CompraItem, String> {
}
