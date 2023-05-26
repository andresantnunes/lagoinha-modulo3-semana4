package com.example.testeaula2.controller;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.service.ProdutoService;
import com.example.testeaula2.service.ProdutoServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoServiceI produtoService;

    public ProdutoController(ProdutoServiceI produtoService) {
        this.produtoService = produtoService;
    }


    @PostMapping //DTO - Data Transfer Object
                    // existe para transportar dados entre classes ou
                    // transportar dado de dentro para fora do sistema e vice-versa
    public ResponseEntity salvarProduto(
            @RequestBody ProdutoDto produtoDto
    ){
        Produto produto = produtoService.salvaProduto(produtoDto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity retornaTodosProdutos(){
        List<Produto> produto = produtoService.buscaTodosProdutos();
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaProduto(
            @PathVariable("id") Long id,
            @RequestBody ProdutoDto produtoDto
    ){
        Produto produto = produtoService.atualizaProduto(id,produtoDto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(
            @PathVariable("id") Long id
    ){
        Boolean produto = produtoService.deletaProduto(id);
        return ResponseEntity.ok(produto);
    }
}
