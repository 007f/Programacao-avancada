package org.example.model;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando Push Notification com a mensagem: " + message);
    }
}
