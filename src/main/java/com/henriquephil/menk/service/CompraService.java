package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.Compra;
import com.henriquephil.menk.domain.CompraItem;
import com.henriquephil.menk.domain.EstoqueMovimento;
import com.henriquephil.menk.domain.enums.EstoqueMovimentoTipo;
import com.henriquephil.menk.exceptions.NoDocumentFoundException;
import com.henriquephil.menk.repository.CompraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompraService {
    private CompraRepository compraRepository;
    private EstoqueService estoqueService;
    private ContaPagarService contaPagarService;

    public CompraService(CompraRepository compraRepository, EstoqueService estoqueService, ContaPagarService contaPagarService) {
        this.compraRepository = compraRepository;
        this.estoqueService = estoqueService;
        this.contaPagarService = contaPagarService;
    }

    public Compra save(Compra compra) {
        compra = compraRepository.save(compra);
        for (CompraItem compraItem : compra.getItens()) {
            estoqueService.movimentar(new EstoqueMovimento(compra.getLocal(),
                    compraItem.getProduto(),
                    EstoqueMovimentoTipo.ENTRADA,
                    compraItem.getQuantidade(),
                    compraItem.getValor(),
                    compraItem));
        }
        contaPagarService.criarPelaOrigem(compra);
        return compra;
    }

    public Page<Compra> findPage(Pageable pageable) {
        return compraRepository.findAll(pageable);
    }

    public Compra findById(String id) {
        return compraRepository.findById(id).orElseThrow(NoDocumentFoundException::new);
    }

}
