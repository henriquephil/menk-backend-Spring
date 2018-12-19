package com.henriquephil.menk.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@ToString
@Document
public class EstoqueLocal {
    private String id;
    @NonNull
    private String descricao;

    protected EstoqueLocal() {}

    public EstoqueLocal(String descricao) {
        this.descricao = descricao;
    }
}
