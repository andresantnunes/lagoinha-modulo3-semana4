package com.example.testeaula2.service;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProdutoService {

    private final ProdutoRespository produtoRepository;

    public ProdutoService(ProdutoRespository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvaProduto(ProdutoDto produtoDto){
        Produto produto = new Produto(
                produtoDto.getNomeProduto(),
                produtoDto.getValorProduto(),
                produtoDto.getValidadeDias(),
                LocalDate.now()
        );

        return produtoRepository.save(produto);
    }

}
