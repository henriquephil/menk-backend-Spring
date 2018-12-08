package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.Entidade;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.EntidadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EntidadeService {
    private EntidadeRepository entidadeRepository;

    public EntidadeService(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    public Entidade save(Entidade entidade) {
        entidade = entidadeRepository.save(entidade);
        return entidade;
    }

    public Page<Entidade> findPage(Pageable pageable) {
        return entidadeRepository.findAll(pageable);
    }

    public Entidade findById(String id) {
        return entidadeRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }
}
