package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.Produto;
import com.henriquephil.menk.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto post(@RequestBody Produto produto) {
        Assert.isTrue(produto.getId() == null, "Atributo id já preenchido");
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public Produto put(@PathVariable String id, @RequestBody Produto produto) {
        Assert.isTrue(!Objects.equals(id, produto.getId()), "Atributo id inconsistente");
        return produtoService.save(produto);
    }

    @GetMapping
    public Page<Produto> getPage(Pageable page) {
        return produtoService.findPage(page);
    }

    @GetMapping("/{id}")
    public Produto get(@PathVariable String id) {
        return produtoService.findById(id);
    }

}
