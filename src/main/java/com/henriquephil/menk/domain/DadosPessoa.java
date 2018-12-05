package com.henriquephil.menk.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.henriquephil.menk.DadosPessoaDeserializer;

@JsonDeserialize(using = DadosPessoaDeserializer.class)
public interface DadosPessoa {
}
