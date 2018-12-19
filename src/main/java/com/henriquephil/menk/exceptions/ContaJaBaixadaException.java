package com.henriquephil.menk.exceptions;

import com.henriquephil.menk.domain.ContaPagar;
import com.henriquephil.menk.domain.ContaReceber;

public class ContaJaBaixadaException extends RuntimeException {
    public ContaJaBaixadaException(ContaPagar contaPagar) {
        super(String.format("Conta a pagar %s já contem pagamentos", contaPagar.getId()));
    }
    public ContaJaBaixadaException(ContaReceber contaReceber) {
        super(String.format("Conta a receber%s já contem pagamentos", contaReceber.getId()));
    }
}
