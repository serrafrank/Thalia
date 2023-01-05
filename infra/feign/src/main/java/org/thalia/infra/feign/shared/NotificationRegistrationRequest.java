package org.thalia.infra.feign.shared;

import lombok.Builder;

@Builder
public record NotificationRegistrationRequest(
    String message,
    String sender,
    Long commentId,
    Long articleId
) {

}
