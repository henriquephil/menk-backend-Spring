package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.Cliente;
import com.henriquephil.menk.repository.ClienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Page<Cliente> findPage(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente findById(String id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
