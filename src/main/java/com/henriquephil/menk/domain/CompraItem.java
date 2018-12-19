package com.henriquephil.menk.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@ToString
@Document
public class CompraItem implements EstoqueMovimentoOrigem {
    private String id;
    @DBRef
    @NonNull
    private Produto produto;
    @NonNull
    private BigDecimal quantidade;
    @NonNull
    private BigDecimal valor;

    protected CompraItem() {}

    public CompraItem(Produto produto, BigDecimal quantidade, BigDecimal valor) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public BigDecimal getTotal() {
        return quantidade.multiply(valor);
    }
}
