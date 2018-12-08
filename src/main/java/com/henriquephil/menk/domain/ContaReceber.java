package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class ContaReceber {
    private String id;
    @NonNull
    private Entidade fornecedor;
    @NonNull
    private Integer parcela;
    @NonNull
    private LocalDate emissao;
    @NonNull
    private LocalDate vencimento;
    @NonNull
    private BigDecimal valor = BigDecimal.ZERO;
    @DBRef
    @NonNull
    private ContaReceberOrigem origem;
    @NonNull
    private List<Recebimento> recebimentos = new ArrayList<>();

    public BigDecimal getTotalAberto() {
        return valor.subtract(recebimentos.stream()
                .map(Recebimento::getValor)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO));
    }
}
