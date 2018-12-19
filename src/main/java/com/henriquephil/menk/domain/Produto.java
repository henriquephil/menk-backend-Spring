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
    private String gtin;
    @NonNull
    private String descricao;
    private String ncm;
    private String unidadeMedida;
    private BigDecimal valorUnitario;

    protected Produto(){}

    public Produto(ProdutoTipo tipo, String gtin, String descricao, String ncm, String unidadeMedida, BigDecimal valorUnitario) {
        this.tipo = tipo;
        this.gtin = gtin;
        this.descricao = descricao;
        this.ncm = ncm;
        this.unidadeMedida = unidadeMedida;
        this.valorUnitario = valorUnitario;
    }
}
