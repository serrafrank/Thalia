package org.thalia.blog.notification;

import org.thalia.clients.feign.shared.NotificationRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRegistrationRequest message) {
        log.info("Received or consumed message: {}", message);
        notificationService.registerNotification(message);
    }
}
