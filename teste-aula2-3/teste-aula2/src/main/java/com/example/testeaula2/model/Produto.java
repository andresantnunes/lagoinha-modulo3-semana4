package com.example.testeaula2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {
    public Produto(String nomeProduto,
                   Double valorProduto,
                   Integer validadeDias,
                   LocalDate dataCriacao) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.validadeDias = validadeDias;
        this.dataCriacao = dataCriacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private Double valorProduto;
    private Integer validadeDias;
    private LocalDate dataCriacao;
}
