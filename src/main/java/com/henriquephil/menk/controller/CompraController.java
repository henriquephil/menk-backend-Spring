package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.Compra;
import com.henriquephil.menk.service.CompraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("compra")
public class CompraController {

    private CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public Compra post(@RequestBody Compra compra) {
        Assert.isTrue(compra.getId() == null, "Atributo id já preenchido");
        return compraService.save(compra);
    }

    @PutMapping("/{id}")
    public Compra put(@PathVariable String id, @RequestBody Compra compra) {
        Assert.isTrue(!Objects.equals(id, compra.getId()), "Atributo id inconsistente");
        return compraService.save(compra);
    }

    @GetMapping
    public Page<Compra> getPage(Pageable page) {
        return compraService.findPage(page);
    }

    @GetMapping("/{id}")
    public Compra get(@PathVariable String id) {
        return compraService.findById(id);
    }

}
