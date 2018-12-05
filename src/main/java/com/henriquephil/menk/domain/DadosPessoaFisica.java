package com.henriquephil.menk.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henriquephil.menk.domain.enums.Sexo;
import lombok.Data;

@Data
@JsonDeserialize(as = DadosPessoaFisica.class)
public class DadosPessoaFisica implements DadosPessoa{
    private String nome;
    private String cpf;
    private Sexo sexo;
}
