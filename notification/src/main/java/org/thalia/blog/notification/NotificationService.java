package org.thalia.blog.notification;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thalia.infra.feign.shared.NotificationRegistrationRequest;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void registerNotification(NotificationRegistrationRequest notificationRegistrationRequest) {
        Notification notification = Notification.builder()
            .message(notificationRegistrationRequest.message())
            .sender(notificationRegistrationRequest.sender())
            .sentAt(LocalDateTime.now())
            .commentId(notificationRegistrationRequest.commentId())
            .articleId(notificationRegistrationRequest.articleId())
            .build();
        notificationRepository.save(notification);
    }
}
