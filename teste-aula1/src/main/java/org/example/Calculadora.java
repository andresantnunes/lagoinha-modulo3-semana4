package org.example;

public class Calculadora {

    public Double soma(Double valor1, Double valor2){
        return valor1+valor2;
    }

    public Double multiplicaEDivide(Double valor1, Double valor2){
        Math.sqrt(2);
        Math.pow(31,3);
        return valor1*valor2/(valor1-valor2);
    }

    public Double bhaskara(Double valor1, Double valor2, Double valor3) {

        double delta = (Math.pow(valor2,2)) + (-4*(valor1*valor3));

        double resultado = (double) ((valor2*(-1)) + Math.sqrt(delta)) / (2*valor1);
//dfasdfasda
        // Math.sqrt(valor1); // raiz quadrada
        // Math.pow(valor1, 2); // potência

        return resultado;
    }
}
