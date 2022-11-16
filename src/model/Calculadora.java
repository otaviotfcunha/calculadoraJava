package model;

import library.CalculadoraException;

public class Calculadora {

    public double somar(double valor1, double valor2) throws CalculadoraException{
        double valorFinal;
        valorFinal = valor1 + valor2;
        return valorFinal;
    }

    public double subtrair(double valor1, double valor2) throws CalculadoraException{
        double valorFinal;
        valorFinal = valor1 - valor2;
        return valorFinal;
    }

    public double dividir(double valor1, double valor2) throws CalculadoraException{
        if(valor2 == 0) throw new CalculadoraException(1);
        double valorFinal;
        valorFinal = valor1 / valor2;
        return valorFinal;
    }

    public double multiplicar(double valor1, double valor2) throws CalculadoraException{
        double valorFinal;
        valorFinal = valor1 * valor2;
        return valorFinal;
    }

}
