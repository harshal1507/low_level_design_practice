package com.example.ecommerce.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void sendNotification(String recipient, String message) {
        // Encapsulate JavaMail or SendGrid SDK logic
        System.out.println("[EMAIL] Sent to " + recipient + ": " + message);
    }

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.EMAIL;
    }
}