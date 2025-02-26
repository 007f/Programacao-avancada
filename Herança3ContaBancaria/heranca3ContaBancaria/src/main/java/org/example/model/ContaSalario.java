package org.example.model;

public class ContaSalario extends ContaCorrente {
    private boolean saqueGratisUtilizado;

    public ContaSalario(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
        this.saqueGratisUtilizado = false;
    }

    @Override
    public void sacar(double valor) {
        if (!saqueGratisUtilizado) {
            if (saldo >= valor) {
                saldo -= valor;
                saqueGratisUtilizado = true;
                System.out.println("Saque gratuito realizado de: R$ " + valor);
            } else {
                System.out.println("Saldo insuficiente para o saque.");
            }
        } else {
            if (saldo >= valor + 5) { // Taxa de R$ 5,00 após o saque gratuito
                saldo -= (valor + 5);
                System.out.println("Saque realizado com taxa de R$ 5,00. Total: R$ " + (valor + 5));
            } else {
                System.out.println("Saldo insuficiente para o saque com taxa.");
            }
        }
    }
}
