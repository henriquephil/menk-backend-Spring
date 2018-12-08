package com.henriquephil.menk.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ContaPagarOrigem {
    CondicaoPagamento getCondicaoPagamento();

    Entidade getFornecedor();

    String getDocumento();

    LocalDate getDataEmissao();

    BigDecimal getTotalLiquido();
}
