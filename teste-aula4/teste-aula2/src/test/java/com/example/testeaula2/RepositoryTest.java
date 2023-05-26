package com.example.testeaula2;

import com.example.testeaula2.model.Produto;
import com.example.testeaula2.repository.ProdutoRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class) // carrega o contexto do Spring, ele traz os models
@DataJpaTest //cria um banco de dados em memória com base nas entities/models do projeto
public class RepositoryTest {

    @Autowired
    ProdutoRespository produtoRespository; // injeção do Produto Repository

    @BeforeEach
    void limpar(){
        produtoRespository.deleteAll();
    }

    @Test
    void testeRepository(){
        // produto repository para o banco de dados fake
        Produto produto =
                new Produto("Bloco de Notas", 5.0, 10000, LocalDate.now());

        // salva o produto no banco de dados
        produtoRespository.save(produto);

        // busca todos os produto no banco de dados
        List<Produto> produtoList = produtoRespository.findAll();

        //valida se os dados encontrados são os que salvamos
        assertNotNull(produtoList);
        assertEquals(produtoList.get(0).getNomeProduto(),produto.getNomeProduto());
    }
}
