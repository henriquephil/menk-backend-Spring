package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.CondicaoPagamento;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.CondicaoPagamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CondicaoPagamentoService {
    private CondicaoPagamentoRepository condicaoPagamentoRepository;

    public CondicaoPagamentoService(CondicaoPagamentoRepository condicaoPagamentoRepository) {
        this.condicaoPagamentoRepository = condicaoPagamentoRepository;
    }

    public CondicaoPagamento save(CondicaoPagamento condicaoPagamento) {
        return condicaoPagamentoRepository.save(condicaoPagamento);
    }

    public Page<CondicaoPagamento> findPage(Pageable pageable) {
        return condicaoPagamentoRepository.findAll(pageable);
    }

    public CondicaoPagamento findById(String id) {
        return condicaoPagamentoRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }

}
