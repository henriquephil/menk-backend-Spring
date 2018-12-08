package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.EstoqueLocal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueLocalRepository extends MongoRepository<EstoqueLocal, String> {
}
