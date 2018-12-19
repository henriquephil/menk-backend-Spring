package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.CondicaoPagamento;
import com.henriquephil.menk.service.CondicaoPagamentoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("condicao-pagamento")
public class CondicaoPagamentoController {
    private CondicaoPagamentoService condicaoPagamentoService;

    public CondicaoPagamentoController(CondicaoPagamentoService condicaoPagamentoService) {
        this.condicaoPagamentoService = condicaoPagamentoService;
    }

    @PostMapping
    public CondicaoPagamento post(@RequestBody CondicaoPagamento condicaoPagamento) {
        Assert.isTrue(condicaoPagamento.getId() == null, "Atributo id já preenchido");
        return condicaoPagamentoService.save(condicaoPagamento);
    }

    @PutMapping("/{id}")
    public CondicaoPagamento put(@PathVariable String id, @RequestBody CondicaoPagamento condicaoPagamento) {
        Assert.isTrue(!Objects.equals(id, condicaoPagamento.getId()), "Atributo id inconsistente");
        return condicaoPagamentoService.save(condicaoPagamento);
    }

    @GetMapping
    public Page<CondicaoPagamento> getPage(Pageable page) {
        return condicaoPagamentoService.findPage(page);
    }

    @GetMapping("/{id}")
    public CondicaoPagamento get(@PathVariable String id) {
        return condicaoPagamentoService.findById(id);
    }

}
