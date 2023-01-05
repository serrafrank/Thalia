package org.thalia.blog.notification;

import org.thalia.clients.feign.shared.NotificationRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
public void registerNotification(NotificationRegistrationRequest notificationRegistrationRequest){
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
