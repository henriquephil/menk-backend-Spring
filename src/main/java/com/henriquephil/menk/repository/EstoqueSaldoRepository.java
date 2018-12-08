package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.EstoqueLocal;
import com.henriquephil.menk.domain.EstoqueSaldo;
import com.henriquephil.menk.domain.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueSaldoRepository extends MongoRepository<EstoqueSaldo, String> {
    Optional<EstoqueSaldo> findByLocalAndProduto(EstoqueLocal local, Produto produto);
}
