package com.henriquephil.menk.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
public class CondicaoPagamentoParcela {
    @NonNull
    private Integer dias;
    @NonNull
    private BigDecimal fracao;

    public CondicaoPagamentoParcela() {}

    public CondicaoPagamentoParcela(Integer dias, BigDecimal fracao) {
        this.dias = dias;
        this.fracao = fracao;
    }
}
