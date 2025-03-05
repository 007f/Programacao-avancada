package org.example;

import org.example.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int esc;

        do {
            System.out.println("/n=== SELECIONA UMA FORMA DE PAGAMENTO ===/n");
            System.out.println("/n1. Pagamento por BOLETO");
            System.out.println("/n2. Pagamento por CARTAO DE CREDITO");
            System.out.println("/n3. Pagamento por PIX");
            Scanner scanner = new Scanner(System.in);
            esc = scanner.nextInt();


            PaymentStrategy forma = null;
            if(esc == 1){
                System.out.println("Pagamento BOLETO selecionado");
                forma = new BoletoPayment();
            }else if(esc == 2){
                System.out.println("Pagamento CARTAO DE CREDITO selecionado");
                forma = new CreditCardPayment();
            } else if(esc ==3){
                System.out.println("Pagamento PIX selecionado");
                forma = new PixPayment();
            } else {
                System.out.println("Esolha incorreta, selecione outra opção");
            }

            PaymentProcessor pagamento = new PaymentProcessor(forma);

        } while (esc != 0);


    }
}
