package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.EstoqueMovimentoTipo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Getter
@ToString
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
    private LocalDateTime data;
    @NonNull
    private EstoqueMovimentoTipo tipo;
    @NonNull
    private BigDecimal quantidade;
    @NonNull
    private BigDecimal valor;
    private BigDecimal quantidadeEstoque;
    private BigDecimal valorEstoque;
    private BigDecimal cmv;
    @DBRef
    @NonNull
    private EstoqueMovimentoOrigem origem;

    public EstoqueMovimento() {}

    public EstoqueMovimento(EstoqueLocal local, Produto produto, LocalDateTime data, EstoqueMovimentoTipo tipo, BigDecimal quantidade, BigDecimal valor, EstoqueMovimentoOrigem origem) {
        this.local = local;
        this.produto = produto;
        this.data = data;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.origem = origem;
    }

    public void corrigeSaldo(BigDecimal quantidadeEstoque, BigDecimal valorEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorEstoque = valorEstoque;
        this.cmv = valorEstoque.divide(quantidadeEstoque, RoundingMode.HALF_UP);
    }
}
