package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.CondicaoPagamento;
import com.henriquephil.menk.domain.CondicaoPagamentoParcela;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.CondicaoPagamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Service
@Transactional
public class CondicaoPagamentoService {
    private CondicaoPagamentoRepository condicaoPagamentoRepository;

    public CondicaoPagamentoService(CondicaoPagamentoRepository condicaoPagamentoRepository) {
        this.condicaoPagamentoRepository = condicaoPagamentoRepository;
    }

    public CondicaoPagamento save(CondicaoPagamento condicaoPagamento) {
        Assert.notEmpty(condicaoPagamento.getParcelas(), "Nenhuma parcela configurada para condição de pagamento");
        BigDecimal totalParcelas = condicaoPagamento.getParcelas().stream().map(CondicaoPagamentoParcela::getFracao).reduce(BigDecimal.ZERO, BigDecimal::add);
        Assert.isTrue(totalParcelas.compareTo(BigDecimal.ONE) == 0, "Total das parcelas não é de 100%");
        return condicaoPagamentoRepository.save(condicaoPagamento);
    }

    public Page<CondicaoPagamento> findPage(Pageable pageable) {
        return condicaoPagamentoRepository.findAll(pageable);
    }

    public CondicaoPagamento findById(String id) {
        return condicaoPagamentoRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }

}
