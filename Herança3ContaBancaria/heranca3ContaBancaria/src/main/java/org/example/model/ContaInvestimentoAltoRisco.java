package org.example.model;

public class ContaInvestimentoAltoRisco extends ContaInvestimento {

    public ContaInvestimentoAltoRisco(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= 10000 && saldo >= valor) {
            double taxaRetirada = valor * 0.05; // 5% de taxa sobre o valor
            saldo -= (valor + taxaRetirada);
            System.out.println("Saque realizado de: R$ " + valor + " com taxa de R$ " + taxaRetirada);
        } else {
            System.out.println("Saldo insuficiente ou saldo abaixo de R$ 10.000,00.");
        }
    }
}