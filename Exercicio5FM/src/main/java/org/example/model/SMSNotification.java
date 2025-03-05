package org.example.model;

public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS com a mensagem: " + message);
    }
}
