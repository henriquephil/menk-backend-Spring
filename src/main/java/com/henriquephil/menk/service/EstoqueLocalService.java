package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.EstoqueLocal;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.EstoqueLocalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstoqueLocalService {
    private EstoqueLocalRepository estoqueLocalRepository;

    public EstoqueLocalService(EstoqueLocalRepository estoqueLocalRepository) {
        this.estoqueLocalRepository = estoqueLocalRepository;
    }

    public EstoqueLocal save(EstoqueLocal estoqueLocal) {
        return estoqueLocalRepository.save(estoqueLocal);
    }

    public Page<EstoqueLocal> findPage(Pageable pageable) {
        return estoqueLocalRepository.findAll(pageable);
    }

    public EstoqueLocal findById(String id) {
        return estoqueLocalRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }

}
