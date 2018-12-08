package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.Compra;
import com.henriquephil.menk.domain.ContaPagar;
import com.henriquephil.menk.domain.ContaPagarOrigem;
import com.henriquephil.menk.domain.enums.EntidadeTipo;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.ContaPagarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class ContaPagarService {
    private ContaPagarRepository contaPagarRepository;

    public ContaPagarService(ContaPagarRepository contaPagarRepository) {
        this.contaPagarRepository = contaPagarRepository;
    }

    public ContaPagar save(ContaPagar contaPagar) {
        Assert.isTrue(contaPagar.getFornecedor().isTipo(EntidadeTipo.FORNECEDOR), "Entidade não é um fornecedor");
        return contaPagarRepository.save(contaPagar);
    }

    private void delete(ContaPagar conta) {
        Assert.isTrue(conta.getPagamentos().isEmpty(), "Conta a pagar já recebida");
        contaPagarRepository.delete(conta);
    }

    public Page<ContaPagar> findPage(Pageable pageable) {
        return contaPagarRepository.findAll(pageable);
    }

    public ContaPagar findById(String id) {
        return contaPagarRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }

    private List<ContaPagar> findByOrigem(ContaPagarOrigem origem) {
        return contaPagarRepository.findByOrigem(origem);
    }

    public void criarPelaOrigem(ContaPagarOrigem origem) {
        findByOrigem(origem).forEach(this::delete);
        final AtomicInteger ai = new AtomicInteger();
        origem.getCondicaoPagamento().getParcelas().forEach(cpParc -> {
            ContaPagar contaPagar = new ContaPagar(origem.getFornecedor(),
                    origem.getDocumento(),
                    ai.incrementAndGet(),
                    origem,
                    origem.getDataEmissao(),
                    origem.getDataEmissao().plusDays(cpParc.getDias()));
            contaPagar.setValor(origem.getTotalLiquido().multiply(cpParc.getFracao()));
            save(contaPagar);
        });
    }
}
