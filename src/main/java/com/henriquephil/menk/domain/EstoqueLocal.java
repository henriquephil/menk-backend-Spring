package com.henriquephil.menk.domain;

import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class EstoqueLocal {
    private String id;
    @NonNull
    private String descricao;
}
