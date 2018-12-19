package com.henriquephil.menk.repository;

import com.henriquephil.menk.domain.EstoqueLocal;
import com.henriquephil.menk.domain.EstoqueMovimento;
import com.henriquephil.menk.domain.EstoqueMovimentoOrigem;
import com.henriquephil.menk.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueMovimentoRepository extends MongoRepository<EstoqueMovimento, String> {
    Optional<EstoqueMovimento> findByOrigem(EstoqueMovimentoOrigem origem);

    Page<EstoqueMovimento> findByLocalAndProdutoAndDataLessThanOrderByDataDesc(EstoqueLocal local, Produto produto, LocalDateTime de, Pageable of);

    List<EstoqueMovimento> findByLocalAndProdutoAndDataGreaterThanEqualOrderByDataAsc(EstoqueLocal local, Produto produto, LocalDateTime de);
}
