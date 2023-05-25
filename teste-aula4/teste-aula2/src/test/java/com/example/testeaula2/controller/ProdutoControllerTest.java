package com.example.testeaula2.controller;

import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRespository;
import com.example.testeaula2.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest // adiciona o contexto do spring boot para os teste abaixo
@AutoConfigureMockMvc // configuração automática do MockMvc
@ExtendWith(SpringExtension.class)
class ProdutoControllerTest {

    @MockBean
    ProdutoRespository produtoRespository;

    @Autowired
    MockMvc mockMvc; // permite a chamada de endpoints diretamente, sem chamar o método

    @Test
    void salvarProduto() throws Exception {
        mockMvc.perform( // executar um teste
                MockMvcRequestBuilders //controi uma requisição
                        .post("/produto") //método POST no endpoint /produto
                        .accept(MediaType.APPLICATION_JSON) // tipo do conteúdo esperado na resposta
                        .contentType(MediaType.APPLICATION_JSON) // tipo do conteúdo enviado
                        .content( // conteúdo do corpo da requisição
                                """
                                {
                                    "nomeProduto":"Garrafa com bolinhas",
                                    "valorProduto":50.0,
                                    "validadeDias": 1000,
                                    "nomeVendedor": "Augusto"
                                }
                                """
                        )
        ).andExpect( // o resultado esperado da chamada acima
                MockMvcResultMatchers.status().isOk()
        ).andExpect( MockMvcResultMatchers.content().json(
                """
                          {
                              "id": 1,
                              "nomeProduto": "Garrafa com bolinhas",
                              "valorProduto": 50.0,
                              "validadeDias": 1000,
                              "dataCriacao": "2023-05-24"
                          }
                          """
        ));
    }

    @Test
    void retornaTodosProdutos() throws Exception {
        List<Produto> produto =
                List.of(
                        new Produto(1L,
                                "Garrafa com bolinhas",
                                50.0,
                                1000,
                                LocalDate.of(2023,5,25))
                );

        when(produtoRespository.findAll()).thenReturn(produto);

        mockMvc.perform( // executar um teste
                MockMvcRequestBuilders //controi uma requisição
                        .get("/produto") //método GET no endpoint /produto
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect( // o resultado esperado da chamada acima
                MockMvcResultMatchers.status().isOk()
        ).andExpect( MockMvcResultMatchers.content().json(
                """
                          [
                                {
                                    "id": 1,
                                    "nomeProduto": "Garrafa com bolinhas",
                                    "valorProduto": 50.0,
                                    "validadeDias": 1000,
                                    "dataCriacao": "2023-05-25"
                                }
                          ]
                          """
        ));
    }

    @Test
    void atualizaProduto() {
    }

    @Test
    void deletarProduto() {
    }
}