package com.henriquephil.menk;

import com.henriquephil.menk.domain.enums.ClienteTipoPessoa;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClienteTipoPessoaConverter implements Converter<String, ClienteTipoPessoa> {
    @Override
    public ClienteTipoPessoa convert(String s) {
        return ClienteTipoPessoa.valueOf(s);
    }
}
