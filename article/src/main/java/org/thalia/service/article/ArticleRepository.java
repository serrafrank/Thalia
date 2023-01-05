package org.thalia.service.article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository
    extends JpaRepository<Article, Long> {

    Article findArticleById(Long articleId);
}

