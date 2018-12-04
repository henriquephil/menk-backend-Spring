package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.ClienteTipoPessoa;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Cliente {
    @NonNull
    private String id;
    private Boolean ativo;
//    private ClienteTipoPessoa tipoPessoa;
//    private Endereco endereco;
//    private DadosPessoa dadosPessoa;
}
