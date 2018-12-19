package com.henriquephil.menk.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@JsonDeserialize(as = DadosPessoaJuridica.class)
public class DadosPessoaJuridica implements DadosPessoa{
    @NonNull
    private String nomeFantasia;
    private String razaoSocial;
    @NonNull
    private String cnpj;
    private String inscricaoEstadual;

    protected DadosPessoaJuridica(){}

    public DadosPessoaJuridica(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
}
