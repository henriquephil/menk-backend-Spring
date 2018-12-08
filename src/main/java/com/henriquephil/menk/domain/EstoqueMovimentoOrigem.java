package com.henriquephil.menk.domain;

import java.math.BigDecimal;

public interface EstoqueMovimentoOrigem {
    EstoqueLocal getLocal();

    Produto getProduto();

    BigDecimal getQuantidade();

    BigDecimal getValor();
}
