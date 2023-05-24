package com.example.testeaula2.service;

import com.example.testeaula2.controller.dto.ProdutoDto;
import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRespository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // adiciona ao comando e anotações do mockito ao teste
class ProdutoServiceTeste {

    @Mock // indica a classe que será mockada, ou seja vai ter valores falsos para as respostas dos métodos
    private ProdutoRespository produtoRepository;

    @InjectMocks // indica a classe que irá receber o Mock, ou seja a classe que vai ter os dados falsos
    private ProdutoService produtoService;


    @Test
    void salvaProduto() {
        // Criamos a reposta padrão do mock para o método Save
        Produto produtoMock =
                new Produto(1L,"Bloco de Notas", 5.0, 10000, LocalDate.now());

        //Indicamos que toda vez que o produtoRepository.save for chamado no código vamos retornar o produtoMock
        when(produtoRepository.save(any())).thenReturn(produtoMock);

        //Realizamos o teste chamando o service
        Produto produtoResposta = produtoService.salvaProduto(
                new ProdutoDto("Sorvete Dass", 5.0, 10000,"Hagen")
        );

        assertNotNull(produtoResposta); // Validamos se a resposta do teste não é nula
        assertEquals(produtoMock.getNomeProduto(), produtoResposta.getNomeProduto());
        // validamos se o nome do produto
        // é igual para Mock e o Resultado

        verify(produtoRepository).save(any()); // Valida se o método save foi executado durante o teste
    }

    @Test
    void buscaTodosProdutos() {
    }
}