package com.example.testeaula2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private String nomeProduto;
    private Double valorProduto;
    private Integer validadeDias;
    private String nomeVendedor;
}
