package com.example.testeaula2.service;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRespository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoServiceI {

    Produto salvaProduto(ProdutoDto produtoDto);
    List<Produto> buscaTodosProdutos();
    Produto atualizaProduto(Long id, ProdutoDto produtoDto) ;
    Boolean deletaProduto(Long id) ;
}
