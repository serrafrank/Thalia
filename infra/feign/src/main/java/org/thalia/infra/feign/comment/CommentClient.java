package org.thalia.infra.feign.comment;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thalia.infra.feign.shared.CommentDto;

@FeignClient(
    name = "comment",
    url = "${feign.comment.url}"
)
public interface CommentClient {

    @GetMapping(path = "api/v1/comments/{articleId}")
    List<CommentDto> getComment(
        @PathVariable(value = "articleId")
        final Long articleId);
}

