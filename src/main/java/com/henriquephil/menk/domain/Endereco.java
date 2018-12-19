package com.henriquephil.menk.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Endereco {
    private String pais;
    private String estado;
    private String cidade;
    private String codigoPostal;
    private String bairro;
    private String endereco;

    public Endereco(){}
}
