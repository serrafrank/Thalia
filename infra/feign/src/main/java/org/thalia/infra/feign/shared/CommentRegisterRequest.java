package org.thalia.infra.feign.shared;

public record CommentRegisterRequest(Long articleId, String body) {

}

