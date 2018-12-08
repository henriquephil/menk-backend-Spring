package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.Entidade;
import com.henriquephil.menk.service.EntidadeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("entidade")
public class EntidadeController {

    private EntidadeService entidadeService;

    public EntidadeController(EntidadeService entidadeService) {
        this.entidadeService = entidadeService;
    }

    @PostMapping
    public Entidade post(@RequestBody Entidade entidade) {
        entidade.setId(null);
        return entidadeService.save(entidade);
    }

    @PutMapping("/{id}")
    public Entidade put(@PathVariable String id, @RequestBody Entidade entidade) {
        entidade.setId(id);
        return entidadeService.save(entidade);
    }

    @GetMapping
    public Page<Entidade> getPage(Pageable page) {
        return entidadeService.findPage(page);
    }

    @GetMapping("/{id}")
    public Entidade get(@PathVariable String id) {
        return entidadeService.findById(id);
    }

}
