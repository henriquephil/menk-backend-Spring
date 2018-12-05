package com.henriquephil.menk.domain;

import lombok.Data;

@Data
public class Endereco {
    private String pais;
    private String estado;
    private String cidade;
    private String codigoPostal;
    private String bairro;
    private String endereco;
}
