package com.henriquephil.menk.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.henriquephil.menk.domain.DadosPessoa;
import com.henriquephil.menk.domain.DadosPessoaFisica;
import com.henriquephil.menk.domain.DadosPessoaJuridica;

import java.io.IOException;

public class DadosPessoaDeserializer extends JsonDeserializer {
    @Override
    public DadosPessoa deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec oc = p.getCodec();
        JsonNode node = oc.readTree(p);
        if (node.has("cpf")) {
            return oc.treeToValue(node, DadosPessoaFisica.class);
        }
        if (node.has("cnpj")) {
            return oc.treeToValue(node, DadosPessoaJuridica.class);
        }
        throw MismatchedInputException.from(p, DadosPessoa.class, "Não foi possível identificar o formado dos dados da pessoa");
    }
}
