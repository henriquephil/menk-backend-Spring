package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.EntidadeTipo;
import com.henriquephil.menk.domain.enums.EntidadeTipoPessoa;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
public class Entidade {
    private String id;
    private Boolean ativo;
    private Set<EntidadeTipo> tipos;
    private EntidadeTipoPessoa tipoPessoa;
    private Endereco endereco;
    private DadosPessoa dadosPessoa;
}
