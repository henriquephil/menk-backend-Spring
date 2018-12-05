package com.henriquephil.menk.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henriquephil.menk.domain.enums.Sexo;
import lombok.Data;

@Data
@JsonDeserialize(as = DadosPessoaJuridica.class)
public class DadosPessoaJuridica implements DadosPessoa{
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
}
