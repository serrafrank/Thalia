package org.thalia.service.comment;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thalia.infra.feign.shared.CommentRegisterRequest;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comments")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentDto registerComment(
        @RequestBody
        CommentRegisterRequest commentRegisterRequest) {
        log.info("new Comment registration {}", commentRegisterRequest);
        return commentService.registerComment(commentRegisterRequest);
    }

    @GetMapping(path = "{articleId}")
    public List<CommentDto> getComment(
        @PathVariable(value = "articleId")
        Long articleId) {
        log.info("get Comment by Article id {}", articleId);
        return commentService.getComment(articleId);
    }

}
