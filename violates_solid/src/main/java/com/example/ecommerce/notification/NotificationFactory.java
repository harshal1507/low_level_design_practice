package com.example.ecommerce.notification;

import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class NotificationFactory {

    private final Map<NotificationChannel, NotificationStrategy> strategyRegistry;

    // Spring autowires all beans implementing NotificationStrategy into strategyList
    public NotificationFactory(List<NotificationStrategy> strategyList) {
        this.strategyRegistry = new EnumMap<>(NotificationChannel.class);
        for (NotificationStrategy strategy : strategyList) {
            this.strategyRegistry.put(strategy.getChannel(), strategy);
        }
    }

    public NotificationStrategy getStrategy(NotificationChannel channel) {
        return Optional.ofNullable(strategyRegistry.get(channel))
                .orElseThrow(() -> new IllegalArgumentException("No strategy registered for channel: " + channel));
    }
}