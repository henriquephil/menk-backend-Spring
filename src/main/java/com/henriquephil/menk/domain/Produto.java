package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.ProdutoTipo;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@ToString
@Document
public class Produto {
    private String id;
    @NonNull
    private Boolean ativo = true;
    @NonNull
    private ProdutoTipo tipo;
    @NonNull
    private String descricao;
    private String gtin;
    private String ncm;
    private String unidadeMedida;
    private BigDecimal valorUnitario;

    protected Produto(){}

    public Produto(ProdutoTipo tipo, String descricao, String gtin, String ncm, String unidadeMedida, BigDecimal valorUnitario) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.gtin = gtin;
        this.ncm = ncm;
        this.unidadeMedida = unidadeMedida;
        this.valorUnitario = valorUnitario;
    }
}
