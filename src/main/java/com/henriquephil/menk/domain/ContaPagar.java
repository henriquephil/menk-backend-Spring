package com.henriquephil.menk.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Document
public class ContaPagar {
    private String id;
    @DBRef
    @NonNull
    private Entidade fornecedor;
    @NonNull
    private String documento;
    @NonNull
    private Integer parcela;
    @DBRef
    @NonNull
    private ContaPagarOrigem origem;
    @NonNull
    private LocalDate dataEmissao;
    @NonNull
    private LocalDate dataVencimento;
    @NonNull
    private BigDecimal valor = BigDecimal.ZERO;
    @NonNull
    private List<Pagamento> pagamentos = new ArrayList<>();

    public ContaPagar() {}

    public ContaPagar(Entidade fornecedor,
                      String documento,
                      Integer parcela,
                      ContaPagarOrigem origem,
                      LocalDate dataEmissao,
                      LocalDate dataVencimento,
                      BigDecimal valor) {
        this.fornecedor = fornecedor;
        this.documento = documento;
        this.parcela = parcela;
        this.origem = origem;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public BigDecimal getTotalPago() {
        return pagamentos.stream().map(Pagamento::getValor).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getTotalAberto() {
        return valor.subtract(getTotalPago());
    }
}
