package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.EntidadePapel;
import com.henriquephil.menk.domain.enums.EntidadeTipoPessoa;
import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@Document
public class Entidade {
    private String id;
    @NonNull
    private Boolean ativo = true;
    @NonNull
    private Set<EntidadePapel> papeis = new HashSet<>();
    @NonNull
    private EntidadeTipoPessoa tipoPessoa;
    private Endereco endereco;
    @NonNull
    private DadosPessoa dadosPessoa;

    protected Entidade(){}

    public Entidade(EntidadeTipoPessoa tipoPessoa, Set<EntidadePapel> papeis, Endereco endereco, DadosPessoa dadosPessoa) {
        this.tipoPessoa = tipoPessoa;
        this.papeis.addAll(papeis);
        this.endereco = endereco;
        this.dadosPessoa = dadosPessoa;
    }

    public boolean hasPapel(EntidadePapel papel) {
        return papeis.contains(papel);
    }
}
