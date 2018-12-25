package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.*;
import com.henriquephil.menk.domain.enums.EntidadePapel;
import com.henriquephil.menk.domain.enums.EntidadeTipoPessoa;
import com.henriquephil.menk.domain.enums.ProdutoTipo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataMongoTest(includeFilters = @ComponentScan.Filter(Service.class))
public class CompraServiceTest {
    @Autowired
    private CompraService compraService;
    @Autowired
    private EntidadeService entidadeService;
    @Autowired
    private EstoqueLocalService estoqueLocalService;
    @Autowired
    private CondicaoPagamentoService condicaoPagamentoService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private EstoqueService estoqueService;
    @Autowired
    private ContaPagarService contaPagarService;

    @Test
    public void save() {
        var endereco = new Endereco("Brasil", "Santa Catarina", "São Ludgero", "88730-000", "Beira Rio", "Rua Joinville, 375");
        var fornecedor = entidadeService.save(new Entidade(EntidadeTipoPessoa.JURIDICA, Set.of(EntidadePapel.FORNECEDOR), endereco, new DadosPessoaJuridica("Menk", "01.333.666/0001-99")));
        var local = estoqueLocalService.save(new EstoqueLocal("Estoque"));
        var condicaoPagamento = condicaoPagamentoService.save(new CondicaoPagamento("30 DIAS", List.of(new CondicaoPagamentoParcela(30, new BigDecimal(1)))));
        var produto1 = produtoService.save(new Produto(ProdutoTipo.PRODUTO, "Produto 1", null, null, "UN", new BigDecimal(100)));

        Compra compra = new Compra(fornecedor, "65489", LocalDate.now(), LocalDateTime.now(), local, condicaoPagamento);
        compra.addItem(new CompraItem(produto1, new BigDecimal(10), new BigDecimal(6.5)));
        compra = compraService.save(compra);
        Assert.assertNotNull(compra.getId());

        Optional<EstoqueMovimento> estoqueMovimento = estoqueService.findByOrigem(compra.getItens().get(0));
        Assert.assertTrue(estoqueMovimento.isPresent());
        Assert.assertEquals(65, estoqueMovimento.get().getValorEstoque().intValue());
        Page<ContaPagar> contaPagar = contaPagarService.findPage(PageRequest.of(0, 1));
        Assert.assertEquals(1, contaPagar.getSize());
        Assert.assertEquals(new BigDecimal(65), contaPagar.getContent().get(0).getValor());
    }


}