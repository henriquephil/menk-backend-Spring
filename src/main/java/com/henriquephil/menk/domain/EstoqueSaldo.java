package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class EstoqueSaldo {
    private String id;
    @DBRef
    @NonNull
    private EstoqueLocal local;
    @DBRef
    @NonNull
    private Produto produto;
    private BigDecimal quantidade = BigDecimal.ZERO;
    private BigDecimal cmv = BigDecimal.ZERO;

}
