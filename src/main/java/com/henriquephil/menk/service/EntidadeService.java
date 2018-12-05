package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.Entidade;
import com.henriquephil.menk.exceptions.NoDataFoundException;
import com.henriquephil.menk.repository.EntidadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EntidadeService {
    private EntidadeRepository entidadeRepository;

    public EntidadeService(EntidadeRepository entidadeRepository) {
        this.entidadeRepository = entidadeRepository;
    }

    public Entidade save(Entidade entidade) {
        return entidadeRepository.save(entidade);
    }

    public Page<Entidade> findPage(Pageable pageable) {
        return entidadeRepository.findAll(pageable);
    }

    public Entidade findById(String id) {
        return entidadeRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }
}
