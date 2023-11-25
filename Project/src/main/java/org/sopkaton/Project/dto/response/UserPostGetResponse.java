package org.sopkaton.Project.dto.response;

import org.sopkaton.Project.domain.Post;
import org.sopkaton.Project.domain.User;

import java.util.List;

public record UserPostGetResponse(
    String ssaId,
    String nickname,
    int ticketCount,
    int dislikeCount,
    List<Post> postList

){
    public static UserPostGetResponse of(User user, List<Post> postList){
        return new UserPostGetResponse(
                user.getSsaId(),
                user.getNickname(),
                user.getTicketCount(),
                user.getDislikeCount(),
                postList
        );
    }
}
