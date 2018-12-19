package com.henriquephil.menk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micrometer.core.lang.NonNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Document
public class Compra implements ContaPagarOrigem {
    private String id;
    @DBRef
    @NonNull
    private Entidade fornecedor;
    @NonNull
    private String documento;
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEmissao;
    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataEntrada;
    @DBRef
    @NonNull
    private EstoqueLocal local;
    private String observacao;
    @DBRef
    @NonNull
    private List<CompraItem> itens = new ArrayList<>();
    @DBRef
    @NonNull
    private CondicaoPagamento condicaoPagamento;

    protected Compra(){}

    public Compra(Entidade fornecedor, String documento, LocalDate dataEmissao, LocalDateTime dataEntrada, EstoqueLocal local, CondicaoPagamento condicaoPagamento) {
        this.fornecedor = fornecedor;
        this.documento = documento;
        this.dataEmissao = dataEmissao;
        this.dataEntrada = dataEntrada;
        this.local = local;
        this.condicaoPagamento = condicaoPagamento;
    }

    public void addItem(CompraItem compraItem) {
        itens.add(compraItem);
    }

    public BigDecimal getTotalLiquido() {
        return itens.stream().map(CompraItem::getTotal).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

}
