package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.CondicaoPagamento;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicaoPagamentoRepository extends MongoRepository<CondicaoPagamento, String> {
}
