package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.CompraItem;
import com.henriquephil.menk.repository.CompraItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraItemService {
    private CompraItemRepository compraItemRepository;

    public CompraItemService(CompraItemRepository compraItemRepository) {
        this.compraItemRepository = compraItemRepository;
    }

    public void deleteAll(List<CompraItem> compraItems) {
        compraItemRepository.deleteAll(compraItems);
    }

    public List<CompraItem> saveAll(List<CompraItem> compraItems) {
        return compraItemRepository.saveAll(compraItems);
    }
}
