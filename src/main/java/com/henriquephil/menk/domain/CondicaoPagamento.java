package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class CondicaoPagamento {
    private String id;
    @NonNull
    private String descricao;
    @NonNull
    private List<CondicaoPagamentoParcela> parcelas;
}
