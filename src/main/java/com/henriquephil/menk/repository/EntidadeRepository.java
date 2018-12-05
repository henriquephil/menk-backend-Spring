package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.Entidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeRepository extends MongoRepository<Entidade, String> {
}
