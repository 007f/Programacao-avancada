package org.example;

import org.example.model.*;


import java.util.Scanner;

// Classe principal que interage diretamente com o usuario
public class Main {
    public static void main(String[] args) {
        //Cria um objeto de visualização
        Visual visual = new Visual();
        int option = visual.selectPaymentOption();  // Chama metodo para o menu de opcoes
        PaymentStrategy strategy = PaymentStrategyFactory.createPaymentStrategy(option);
        double amount = visual.getPaymentAmount();  // Chama metodo para receber o valor do pagamento

        // Executa o pagamento de acordo com a estrategia que o usuario escolheu em tempo de execucao
        PaymentProcessor processor = new PaymentProcessor(strategy);
        processor.executePayment(amount);
    }
}
