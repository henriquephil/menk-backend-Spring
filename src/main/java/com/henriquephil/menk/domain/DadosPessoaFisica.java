package com.henriquephil.menk.domain;

import lombok.Data;

@Data
public class DadosPessoaFisica implements DadosPessoa{
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
}
