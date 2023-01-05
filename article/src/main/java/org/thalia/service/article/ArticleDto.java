package org.thalia.service.article;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thalia.infra.feign.shared.CommentDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private long articleId;
    private String title;
    private String body;
    private List<CommentDto> comments;
    private Instant createdAt;
    private Instant updatedAt;
}

