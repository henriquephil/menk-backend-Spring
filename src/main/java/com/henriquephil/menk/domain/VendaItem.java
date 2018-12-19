package com.henriquephil.menk.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@ToString
@Document
public class VendaItem implements EstoqueMovimentoOrigem {
    private String id;
    @DBRef
    @NonNull
    private Produto produto;
    @NonNull
    private BigDecimal quantidade = BigDecimal.ZERO;
    @NonNull
    private BigDecimal valor = BigDecimal.ZERO;
    @NonNull
    private BigDecimal descontoTotal = BigDecimal.ZERO;

    public BigDecimal getTotalBruto() {
        return quantidade.multiply(valor);
    }

    public BigDecimal getTotalLiquido() {
        return getTotalBruto().subtract(descontoTotal);
    }
}
