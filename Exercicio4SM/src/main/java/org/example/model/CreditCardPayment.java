package org.example.model;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero do cartão: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Valor: " + amount);
    }
}
