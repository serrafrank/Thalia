package org.thalia.blog.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thalia.infra.feign.shared.NotificationRegistrationRequest;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping()
    public void registerNotification(
        @RequestBody
        NotificationRegistrationRequest notificationRegistrationRequest) {
        log.info("new Notification registration {}", notificationRegistrationRequest);
        notificationService.registerNotification(notificationRegistrationRequest);
    }
}
