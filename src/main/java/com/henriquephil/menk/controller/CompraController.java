package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.Compra;
import com.henriquephil.menk.service.CompraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compra")
public class CompraController {

    private CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public Compra post(@RequestBody Compra compra) {
        compra.setId(null);
        return compraService.save(compra);
    }

    @PutMapping("/{id}")
    public Compra put(@PathVariable String id, @RequestBody Compra compra) {
        compra.setId(id);
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
