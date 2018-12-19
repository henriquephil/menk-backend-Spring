package com.henriquephil.menk.domain;

import java.math.BigDecimal;

public interface EstoqueMovimentoOrigem {
    String getId();
    Produto getProduto();
    BigDecimal getQuantidade();
    BigDecimal getValor();
}
