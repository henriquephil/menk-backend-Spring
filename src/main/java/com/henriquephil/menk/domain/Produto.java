package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.ProdutoTipo;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Produto {
    private String id;
    private ProdutoTipo tipo;
    private String gtin;
    private String descricao;
    private String ncm;
    private String unidadeMedida;
    private BigDecimal valorUnitario;
}
