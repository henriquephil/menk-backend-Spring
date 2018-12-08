package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.EstoqueMovimento;
import com.henriquephil.menk.domain.EstoqueMovimentoOrigem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueMovimentoRepository extends MongoRepository<EstoqueMovimento, String> {
    Optional<EstoqueMovimento> findByOrigem(EstoqueMovimentoOrigem origem);
}
