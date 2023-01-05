package org.thalia.clients.feign.comment;

import org.thalia.clients.feign.shared.CommentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "comment",
        url = "${feign.comment.url}"
)
public interface CommentClient {

    @GetMapping(path = "api/v1/comments/{articleId}")
    List<CommentDto> getComment(@PathVariable(value = "articleId") final Long articleId);
}

