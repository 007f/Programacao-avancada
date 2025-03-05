package org.example.model;

public class NotificationFactory {

    public static Notification createNotification(String type) {
        switch (type) {
            case "1":
                return new EmailNotification();
            case "2":
                return new SMSNotification();
            case "3":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Tipo de notificação inválido.");
        }
    }
}

