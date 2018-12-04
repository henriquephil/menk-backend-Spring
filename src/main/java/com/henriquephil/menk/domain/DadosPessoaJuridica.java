package com.henriquephil.menk.domain;

import com.henriquephil.menk.domain.enums.Sexo;
import lombok.Data;

@Data
public class DadosPessoaJuridica implements DadosPessoa{
    private String nome;
    private String cpf;
    private Sexo sexo;
}
