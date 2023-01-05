package org.thalia.infra.feign.shared;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private long commentId;
    private long articleId;
    private String body;
    private Instant createdAt;
    private Instant updatedAt;
}


