package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTeste {

    @Test // Identifica um teste que será executado pelo JUnit
    void somaTeste(){ //método onde o teste será executado
        Calculadora calculadora = new Calculadora();

        double resultado = calculadora.soma(1.4,2.0);

        assertEquals(3.4, resultado);
    }

    @Test
    void multiplicaTeste(){
        Calculadora calculadora = new Calculadora();
        Calculadora calculadora2 = null;
        Calculadora calculadora3 = calculadora;

        double resultado = calculadora.multiplicaEDivide(11.0,10.0);

        assertEquals(110.0, resultado); // valida se 2 valores são identicos
        assertNull(calculadora2); // valida se uma variável tem valor null
        assertNotNull(calculadora); // valida se uma variável não tem o valor null
        assertSame(calculadora, calculadora3); // valida se 2 variaveis são do mesmo tipo


    }

    // calculadora completa:
    // multiplicação, divisão, soma, subtração, formula de bascara
}
