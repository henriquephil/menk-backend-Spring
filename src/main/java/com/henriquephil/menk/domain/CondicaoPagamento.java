package com.henriquephil.menk.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Document
public class CondicaoPagamento {
    private String id;
    @NonNull
    private String descricao;
    @NonNull
    private List<CondicaoPagamentoParcela> parcelas = new ArrayList<>();

    public CondicaoPagamento() {}

    public CondicaoPagamento(String descricao, List<CondicaoPagamentoParcela> parcelas) {
        this.descricao = descricao;
        this.parcelas.addAll(parcelas);
    }

    public void addParcela(CondicaoPagamentoParcela parcela) {
        parcelas.add(parcela);
    }
}
