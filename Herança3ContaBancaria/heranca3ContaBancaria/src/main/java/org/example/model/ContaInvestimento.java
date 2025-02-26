package org.example.model;

public class ContaInvestimento extends ContaBancaria {

    public ContaInvestimento(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double taxaRetirada = valor * 0.02; // 2% de taxa sobre o valor
        if (saldo >= valor + taxaRetirada) {
            saldo -= (valor + taxaRetirada);
            System.out.println("Saque realizado de: R$ " + valor + " com taxa de R$ " + taxaRetirada);
        } else {
            System.out.println("Saldo insuficiente para o saque, incluindo taxa.");
        }
    }
}
