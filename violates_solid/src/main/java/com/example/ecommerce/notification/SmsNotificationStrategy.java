package com.example.ecommerce.notification;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public void sendNotification(String recipient, String message) {
        // Encapsulate Twilio or AWS SNS SDK logic
        System.out.println("[SMS] Sent to " + recipient + ": " + message);
    }

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.SMS;
    }
}