package com.henriquephil.menk.repository.converter;

import com.henriquephil.menk.domain.DadosPessoa;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DadosPessoaConverter implements Converter<DBObject, DadosPessoa> {
    @Override
    public DadosPessoa convert(DBObject dbObject) {

        return null;
    }
}
