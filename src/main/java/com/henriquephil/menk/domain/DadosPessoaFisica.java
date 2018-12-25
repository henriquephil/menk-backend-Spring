package com.henriquephil.menk.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henriquephil.menk.domain.enums.Sexo;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@JsonDeserialize(as = DadosPessoaFisica.class)
public class DadosPessoaFisica implements DadosPessoa{
    @NonNull
    private String nome;
    @NonNull
    private String cpf;
    private LocalDate dataNascimento;
    @NonNull
    private Sexo sexo;
}
