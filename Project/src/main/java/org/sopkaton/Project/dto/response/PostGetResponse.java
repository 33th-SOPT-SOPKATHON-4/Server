package org.sopkaton.Project.dto.response;

import org.sopkaton.Project.domain.Post;

public record PostGetResponse(
        Long postId,
        String postImg,
        String postContent,
        int postDislikeCount,
        String createdDateTime

){
    public static PostGetResponse of(Post post){
        return new PostGetResponse(
                post.getPostId(),
                post.getPostImg(),
                post.getPostContent(),
                post.getPostDislikeCount(),
                post.getCreatedDateTime().split(" ")[0].replace("-", ".")
        );
    }
}