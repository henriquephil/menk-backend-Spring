package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.DadosPessoaFisica;
import com.henriquephil.menk.domain.DadosPessoaJuridica;
import com.henriquephil.menk.domain.Entidade;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.EntidadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class EntidadeService {
    private EntidadeRepository entidadeRepository;

    public EntidadeService(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    public Entidade save(Entidade entidade) {
        switch (entidade.getTipoPessoa()) {
            case FISICA:
                Assert.isTrue(entidade.getDadosPessoa() instanceof DadosPessoaFisica, "Tipo de pessoa e dados da poessoa incoerentes");
                break;
            case JURIDICA:
                Assert.isTrue(entidade.getDadosPessoa() instanceof DadosPessoaJuridica, "Tipo de pessoa e dados da poessoa incoerentes");
                break;
        }
        return entidadeRepository.save(entidade);
    }

    public Page<Entidade> findPage(Pageable pageable) {
        return entidadeRepository.findAll(pageable);
    }

    public Entidade findById(String id) {
        return entidadeRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }
}
