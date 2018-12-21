package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.EstoqueLocal;
import com.henriquephil.menk.service.EstoqueLocalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("estoque-local")
public class EstoqueLocalController {
    private EstoqueLocalService estoqueLocalService;

    public EstoqueLocalController(EstoqueLocalService estoqueLocalService) {
        this.estoqueLocalService = estoqueLocalService;
    }

    @PostMapping
    public EstoqueLocal post(@RequestBody EstoqueLocal estoqueLocal) {
        Assert.isTrue(estoqueLocal.getId() == null, "Atributo id já preenchido");
        return estoqueLocalService.save(estoqueLocal);
    }

    @PutMapping("/{id}")
    public EstoqueLocal put(@PathVariable String id, @RequestBody EstoqueLocal estoqueLocal) {
        Assert.isTrue(Objects.equals(id, estoqueLocal.getId()), "Atributo id inconsistente");
        return estoqueLocalService.save(estoqueLocal);
    }

    @GetMapping
    public Page<EstoqueLocal> getPage(Pageable page) {
        return estoqueLocalService.findPage(page);
    }

    @GetMapping("/{id}")
    public EstoqueLocal get(@PathVariable String id) {
        return estoqueLocalService.findById(id);
    }

}
