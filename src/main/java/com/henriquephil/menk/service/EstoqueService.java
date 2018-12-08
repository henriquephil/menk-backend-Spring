package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.*;
import com.henriquephil.menk.domain.enums.EstoqueMovimentoTipo;
import com.henriquephil.menk.repository.EstoqueMovimentoRepository;
import com.henriquephil.menk.repository.EstoqueSaldoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EstoqueService {
    private EstoqueMovimentoRepository estoqueMovimentoRepository;
    private EstoqueSaldoRepository estoqueSaldoRepository;

    public EstoqueService(EstoqueMovimentoRepository estoqueMovimentoRepository, EstoqueSaldoRepository estoqueSaldoRepository) {
        this.estoqueMovimentoRepository = estoqueMovimentoRepository;
        this.estoqueSaldoRepository = estoqueSaldoRepository;
    }

    public EstoqueMovimento save(EstoqueMovimento movimento) {
        // TODO calcular/recalcular CMV, veriricar se mudou produto
        movimento = estoqueMovimentoRepository.save(movimento);
        EstoqueSaldo saldo = getSaldo(movimento.getLocal(), movimento.getProduto());
        saldo.setQuantidade(saldo.getQuantidade().add(movimento.getQuantidade()));
        estoqueSaldoRepository.save(saldo);
        return movimento;
    }

    public void delete(EstoqueMovimento movimento) {
        // TODO calcular/recalcular CMV
        estoqueMovimentoRepository.delete(movimento);
        EstoqueSaldo saldo = getSaldo(movimento.getLocal(), movimento.getProduto());
        saldo.setQuantidade(saldo.getQuantidade().subtract(movimento.getQuantidade()));
        estoqueSaldoRepository.save(saldo);
    }

    public EstoqueSaldo getSaldo(EstoqueLocal local, Produto produto) {
        return estoqueSaldoRepository.findByLocalAndProduto(local, produto).orElse(new EstoqueSaldo(local, produto));
    }

    public Optional<EstoqueMovimento> findByOrigem(EstoqueMovimentoOrigem origem) {
        // TODO verificar se consulta por origem funciona como esperado
        return estoqueMovimentoRepository.findByOrigem(origem);
    }

    public EstoqueMovimento criarPelaOrigem(EstoqueMovimentoOrigem origem, EstoqueMovimentoTipo tipo) {
        return save(new EstoqueMovimento(origem.getLocal(),
                origem.getProduto(),
                tipo,
                origem.getQuantidade(),
                origem.getValor(),
                origem));
    }

    public EstoqueMovimento movimentar(final EstoqueMovimento estoqueMovimento) {
        //TODO implementar método, de verdade
        Optional<EstoqueMovimento> movimento = findByOrigem(estoqueMovimento.getOrigem());
        if (movimento.isPresent()) {
            EstoqueMovimento mov = movimento.get();
            mov.setProduto(estoqueMovimento.getProduto());
            mov.setQuantidade(estoqueMovimento.getQuantidade());
            mov.setValor(estoqueMovimento.getValor());
            return save(mov);
        } else {
            return save(estoqueMovimento);
        }
    }
}
