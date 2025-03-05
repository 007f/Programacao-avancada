package org.example.model;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando e-mail com a mensagem: " + message);
    }
}
