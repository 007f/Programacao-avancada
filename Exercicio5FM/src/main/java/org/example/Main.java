package org.example;
import org.example.model.Notification;
import org.example.model.NotificationFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        String message

        // Exibe o menu de opções para o usuário
        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: E-mail");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");

        // Lê a opção do usuário
        choice = scanner.nextLine();

        // Solicita a mensagem a ser enviada
        System.out.print("Digite a mensagem a ser enviada: ");
        message = scanner.nextLine();

        // Cria a notificação correta usando a fábrica
        Notification notification = NotificationFactory.createNotification(choice);

        // Envia a mensagem
        notification.send(message);

        scanner.close();
    }
}
