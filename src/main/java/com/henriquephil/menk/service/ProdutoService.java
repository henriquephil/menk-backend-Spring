package com.henriquephil.menk.service;

import com.henriquephil.menk.domain.Produto;
import com.henriquephil.menk.exceptions.NoDataFoundException;
import com.henriquephil.menk.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Page<Produto> findPage(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto findById(String id) {
        return produtoRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }
}
