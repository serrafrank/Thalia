package org.thalia.service.article;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/articles")
@AllArgsConstructor
public class ArticleController {

    public final ArticleService articleService;

    @PostMapping
    public void registerArticle(@RequestBody ArticleRegisterRequest articleRegisterRequest){
        log.info("new Article registration {}", articleRegisterRequest);
        articleService.registerArticle(articleRegisterRequest);
    }

    @GetMapping(path = "{articleId}")
    public ArticleDto findArticle(@PathVariable(value = "articleId") final Long articleId) {

        return articleService.findFullDetailsArticle(articleId);
    }

}
