package com.example.testeaula2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // adiciona o contexto do spring boot para os teste abaixo
@AutoConfigureMockMvc // configuração automática do MockMvc
class ProdutoControllerTest {

    @Autowired
    MockMvc mockMvc; // permite a chamada de endpoints diretamente, sem chamar o método

    @Test
    void salvarProduto() {
    }

    @Test
    void retornaTodosProdutos() throws Exception {
        mockMvc.perform( // executar um teste
                MockMvcRequestBuilders //controi uma requisição
                        .get("/produto") //método GET no endpoint /produto
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect( // o resultado esperado da chamada acima
                MockMvcResultMatchers.status().isOk()
        ).andExpect( MockMvcResultMatchers.content().json(
                """
                          []
                          """
        ));
    }
}