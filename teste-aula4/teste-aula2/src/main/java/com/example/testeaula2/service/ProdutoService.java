package com.example.testeaula2.service;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRespository produtoRepository;

    public ProdutoService(ProdutoRespository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvaProduto(ProdutoDto produtoDto){
        // produtoDto
        // Produto - Sorvete Dass
        // Valor -  5.0
        // Validade - 10000
        // Vendedor - Hagen

        Produto produto = new Produto(
                produtoDto.getNomeProduto(),
                produtoDto.getValorProduto(),
                produtoDto.getValidadeDias(),
                LocalDate.now()
        );

        // Vendedor - Hagen
        System.out.println("Vendedor: " + produtoDto.getNomeVendedor());

        return produtoRepository.save(produto);

        // save(produto) retorna:
        // id - 1L
        // nome - Bloco de Notas
        // ...
    }

    public List<Produto> buscaTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto atualizaProduto(Long id, ProdutoDto produtoDto) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produto.setNomeProduto(
                // se o "produtoDto" não tiver nomeProduto, então iremos manter o nome de "produto",
                // caso o contrário (produtoDto tem nomeProduto) então iremos salvar o nomeProduto do produtoDto
                produtoDto.getNomeProduto() == null ? produto.getNomeProduto() : produtoDto.getNomeProduto()
        );
        produto.setValorProduto(
                produtoDto.getValorProduto() == null ? produto.getValorProduto() : produtoDto.getValorProduto()
        );
        produto.setValidadeDias(
                produtoDto.getValidadeDias() == null ? produto.getValidadeDias() : produtoDto.getValidadeDias()
        );
        return produtoRepository.save(produto);
    }

    public Boolean deletaProduto(Long id) {
        produtoRepository.deleteById(id);
        return true;
    }
}
