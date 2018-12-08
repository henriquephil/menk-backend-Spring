package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CondicaoPagamentoParcela {
    @NonNull
    private Integer dias;
    @NonNull
    private BigDecimal fracao;
}
