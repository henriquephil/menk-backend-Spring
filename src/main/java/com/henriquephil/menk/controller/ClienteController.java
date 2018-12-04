package com.henriquephil.menk.controller;

import com.henriquephil.menk.domain.Cliente;
import com.henriquephil.menk.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public void post(@RequestBody Cliente cliente) {
        cliente.setId(null);
        clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable String id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteService.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable String id) {
        return new Cliente(id);
    }

}
