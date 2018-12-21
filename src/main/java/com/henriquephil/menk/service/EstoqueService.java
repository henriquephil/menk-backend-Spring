package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.*;
import com.henriquephil.menk.domain.enums.EstoqueMovimentoTipo;
import com.henriquephil.menk.repository.EstoqueMovimentoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstoqueService {
    private EstoqueMovimentoRepository estoqueMovimentoRepository;

    public EstoqueService(EstoqueMovimentoRepository estoqueMovimentoRepository) {
        this.estoqueMovimentoRepository = estoqueMovimentoRepository;
    }

    public void recalcularEstoque(EstoqueLocal local, Produto produto, LocalDateTime de) {
        Optional<EstoqueMovimento> ultimoMovimento = estoqueMovimentoRepository
                .findByLocalAndProdutoAndDataLessThanOrderByDataDesc(local, produto, de, PageRequest.of(0, 1))
                .stream().findFirst();
        BigDecimal quantidadeFinal = ultimoMovimento.map(EstoqueMovimento::getQuantidadeEstoque).orElse(BigDecimal.ZERO);
        BigDecimal valorFinal = ultimoMovimento.map(EstoqueMovimento::getValorEstoque).orElse(BigDecimal.ZERO);
        List<EstoqueMovimento> movimentos = estoqueMovimentoRepository.findByLocalAndProdutoAndDataGreaterThanEqualOrderByDataAsc(local, produto, de);
        for (EstoqueMovimento movimento : movimentos) {
            switch (movimento.getTipo()) {
                case ENTRADA:
                    quantidadeFinal = quantidadeFinal.add(movimento.getQuantidade());
                    valorFinal = valorFinal.add(movimento.getValor().multiply(movimento.getQuantidade()));
                    break;
                case SAIDA:
                    quantidadeFinal = quantidadeFinal.subtract(movimento.getQuantidade());
                    valorFinal = valorFinal.subtract(movimento.getValor().multiply(movimento.getQuantidade()));
                    break;
            }
            movimento.corrigeSaldo(quantidadeFinal, valorFinal);
            estoqueMovimentoRepository.save(movimento);
        }
    }

    public EstoqueMovimento save(EstoqueMovimento movimento) {
        movimento = estoqueMovimentoRepository.save(movimento);
        recalcularEstoque(movimento.getLocal(), movimento.getProduto(), movimento.getData());
        return movimento;
    }

    public EstoqueMovimento save(EstoqueLocal local, LocalDateTime dataMovimento, EstoqueMovimentoOrigem origem, EstoqueMovimentoTipo tipo) {
        findByOrigem(origem).ifPresent(this::delete);
        return save(new EstoqueMovimento(local,
                origem.getProduto(),
                dataMovimento,
                tipo,
                origem.getQuantidade(),
                origem.getValor(),
                origem));
    }

    public void delete(EstoqueMovimento movimento) {
        estoqueMovimentoRepository.delete(movimento);
        recalcularEstoque(movimento.getLocal(), movimento.getProduto(), movimento.getData());
    }

    public Optional<EstoqueMovimento> findByOrigem(EstoqueMovimentoOrigem origem) {
        // TODO verificar se consulta por origem funciona como esperado
        return estoqueMovimentoRepository.findByOrigem(origem);
    }
}
