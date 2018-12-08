package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CompraItem implements EstoqueMovimentoOrigem {
    @DBRef
    @NonNull
    private Produto produto;
    @NonNull
    private BigDecimal quantidade;
    @NonNull
    private BigDecimal valor;

    public BigDecimal getTotal() {
        return quantidade.multiply(valor);
    }
}
