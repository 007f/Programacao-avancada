package org.example;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente("001", "João", 500, 1000);
        ContaPoupanca contaPoupanca = new ContaPoupanca("002", "Maria", 1000);
        ContaInvestimento contaInvestimento = new ContaInvestimento("003", "Carlos", 2000);
        ContaSalario contaSalario = new ContaSalario("004", "Ana", 3000, 500);
        ContaInvestimentoAltoRisco contaInvestimentoAltoRisco = new ContaInvestimentoAltoRisco("005", "Lucas", 15000);


        contaCorrente.depositar(500);
        contaPoupanca.depositar(200);
        contaInvestimento.depositar(300);


        contaCorrente.sacar(1000); // Inclui cheque especial
        contaPoupanca.sacar(500);  // Não pode ultrapassar o saldo
        contaInvestimento.sacar(1000); // Com taxa de 2%
        contaSalario.sacar(300); // Saque gratuito
        contaSalario.sacar(200); // Saque com taxa
        contaInvestimentoAltoRisco.sacar(12000); // Com taxa de 5%

        // Exibindo informações
        contaCorrente.exibirInformacoes();
        contaPoupanca.exibirInformacoes();
        contaInvestimento.exibirInformacoes();
        contaSalario.exibirInformacoes();
        contaInvestimentoAltoRisco.exibirInformacoes();
    }
}