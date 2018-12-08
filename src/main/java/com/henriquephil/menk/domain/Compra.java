package com.henriquephil.menk.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Compra implements ContaPagarOrigem {
    private String id;
    @DBRef
    @NonNull
    private Entidade fornecedor;
    @NonNull
    private String documento;
    @NonNull
    private LocalDate dataEmissao;
    @NonNull
    private LocalDate dataEntrada;
    @DBRef
    @NonNull
    private EstoqueLocal local;
    private String observacao;
    @NonNull
    private List<CompraItem> itens = new ArrayList<>();
    @DBRef
    @NonNull
    private CondicaoPagamento condicaoPagamento;
    @DBRef(lazy = true)
    private List<ContaPagar> contasPagar = new ArrayList<>();

    public BigDecimal getTotalLiquido() {
        return itens.stream().map(CompraItem::getTotal).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
