package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class VendaItem implements EstoqueMovimentoOrigem {
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
