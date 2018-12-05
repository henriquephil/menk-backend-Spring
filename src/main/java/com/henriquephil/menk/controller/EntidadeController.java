package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.Entidade;
import com.henriquephil.menk.service.EntidadeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("entidade")
public class EntidadeController {

    private EntidadeService entidadeService;

    public EntidadeController(EntidadeService entidadeService) {
        this.entidadeService = entidadeService;
    }

    @PostMapping
    public void post(@RequestBody Entidade entidade) {
        entidade.setId(null);
        entidadeService.save(entidade);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable String id, @RequestBody Entidade entidade) {
        entidade.setId(id);
        entidadeService.save(entidade);
    }

    @GetMapping("/{id}")
    public Entidade get(@PathVariable String id) {
        return entidadeService.findById(id);
    }

}
