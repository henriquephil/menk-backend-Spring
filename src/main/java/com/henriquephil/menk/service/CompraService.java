package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.Compra;
import com.henriquephil.menk.domain.enums.EstoqueMovimentoTipo;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.CompraItemRepository;
import com.henriquephil.menk.repository.CompraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompraService {
    private CompraRepository compraRepository;
    private CompraItemRepository compraItemRepository;
    private ContaPagarService contaPagarService;
    private EstoqueService estoqueService;

    public CompraService(CompraRepository compraRepository, CompraItemRepository compraItemRepository, ContaPagarService contaPagarService, EstoqueService estoqueService) {
        this.compraRepository = compraRepository;
        this.compraItemRepository = compraItemRepository;
        this.contaPagarService = contaPagarService;
        this.estoqueService = estoqueService;
    }

    public Compra save(Compra compra) {
        saveItens(compra);
        compra = compraRepository.save(compra);
        contaPagarService.saveFrom(compra);
        return findById(compra.getId());
    }

    private void saveItens(Compra compra) {
        if (compra.getId() != null) {
            compraRepository.findById(compra.getId()).map(Compra::getItens).ifPresent(compraItemRepository::deleteAll);
        }
        compra.getItens().forEach(item -> {
            compraItemRepository.save(item);
            estoqueService.save(compra.getLocal(), compra.getDataEntrada(), item, EstoqueMovimentoTipo.ENTRADA);
        });
    }

    public Page<Compra> findPage(Pageable pageable) {
        return compraRepository.findAll(pageable);
    }

    public Compra findById(String id) {
        return compraRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }

}
