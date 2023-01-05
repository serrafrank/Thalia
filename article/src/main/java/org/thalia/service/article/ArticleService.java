package org.thalia.service.article;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thalia.infra.feign.comment.CommentClient;
import org.thalia.infra.feign.shared.CommentDto;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final CommentClient commentClient;

    public void registerArticle(ArticleRegisterRequest articleRegisterRequest) {

        Article article = Article.builder()
            .title(articleRegisterRequest.title())
            .body(articleRegisterRequest.body())
            .createdAt(Instant.now())
            .updatedAt(Instant.now())
            .build();
        articleRepository.save(article);
    }

    public ArticleDto findFullDetailsArticle(final Long articleId) {
        final Article article = articleRepository.findArticleById(articleId);
        return ArticleDto.builder()
            .articleId(article.getId())
            .title(article.getTitle())
            .body(article.getBody())
            .comments(fillAdditionalData(article))
            .createdAt(article.getCreatedAt())
            .updatedAt(article.getUpdatedAt())
            .build();
    }

    private List<CommentDto> fillAdditionalData(final Article article) {

        return commentClient.getComment(article.getId());
    }

}
