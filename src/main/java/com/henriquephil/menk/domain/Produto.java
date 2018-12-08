package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.ProdutoTipo;
import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
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
}
