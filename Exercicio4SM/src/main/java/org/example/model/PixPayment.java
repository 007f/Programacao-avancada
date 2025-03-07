package org.example.model;

public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Chave pix: 007felipe.mello@gmail.com");
        System.out.println("Valor: " + amount);
    }
}
