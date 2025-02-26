package org.example.model;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado de: R$ " + valor);
        } else {
            System.out.println("Saldo insuficiente para o saque.");
        }
    }
}
