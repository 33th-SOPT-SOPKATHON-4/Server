package org.sopkaton.Project.dto.response;

import org.sopkaton.Project.domain.User;

public record UserGetResponse (
    String ssaId,
    String nickname,
    int ticketCount,
    int dislikeCount

){
    public static UserGetResponse of(User user){
        return new UserGetResponse(
                user.getSsaId(),
                user.getNickname(),
                user.getTicketCount(),
                user.getDislikeCount()
        );
    }
}
