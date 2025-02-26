package org.example.model;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado de: R$ " + valor);
        } else {
            System.out.println("Saldo insuficiente, incluindo limite do cheque especial.");
        }
    }
}
