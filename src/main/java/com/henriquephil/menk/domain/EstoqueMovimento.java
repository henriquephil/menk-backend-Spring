package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.EstoqueMovimentoTipo;
import lombok.NonNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class EstoqueMovimento {
    private String id;
    @DBRef
    @NonNull
    private EstoqueLocal local;
    @DBRef
    @NonNull
    private Produto produto;
    @NonNull
    private EstoqueMovimentoTipo tipo;
    @NonNull
    private BigDecimal quantidade;
    @NonNull
    private BigDecimal valor;
    private BigDecimal cmv;
    @DBRef
    @NonNull
    private EstoqueMovimentoOrigem origem;
}
