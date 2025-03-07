package org.example.model;

public class BoletoPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Boleto de indentificação: 123456782345 Criando com sucesso");
        System.out.println("Valor: " + amount);
    }
}
