package org.example.model;

abstract class ContaBancaria {
    protected String numeroConta;
    protected String titular;
    protected double saldo;

    // Construtor que inicializa os atributos
    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    // Método para depositar valor
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado: R$ " + valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método abstrato para saque (a ser implementado pelas subclasses)
    public abstract void sacar(double valor);

    // Método para exibir informações da conta
    public void exibirInformacoes() {
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}