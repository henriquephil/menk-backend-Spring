package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.EntidadeTipo;
import com.henriquephil.menk.domain.enums.EntidadeTipoPessoa;
import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Document
public class Entidade {
    private String id;
    @NonNull
    private Boolean ativo = true;
    @NonNull
    private Set<EntidadeTipo> tipos = new HashSet<>();
    @NonNull
    private EntidadeTipoPessoa tipoPessoa;
    private Endereco endereco;
    @NonNull
    private DadosPessoa dadosPessoa;

    public boolean isTipo(EntidadeTipo tipo) {
        return tipos.contains(tipo);
    }
}
