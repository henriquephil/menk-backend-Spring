package com.henriquephil.menk.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henriquephil.menk.domain.enums.Sexo;
import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonDeserialize(as = DadosPessoaJuridica.class)
public class DadosPessoaJuridica implements DadosPessoa{
    @NonNull
    private String nomeFantasia;
    private String razaoSocial;
    @NonNull
    private String cnpj;
    private String inscricaoEstadual;
}
