package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.ContaPagar;
import com.henriquephil.menk.domain.ContaPagarOrigem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaPagarRepository extends MongoRepository<ContaPagar, String> {
    List<ContaPagar> findByOrigem(ContaPagarOrigem origem);
}
