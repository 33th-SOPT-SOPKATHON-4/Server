package org.sopkaton.Project;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    private String ssaId;
    private String nickname;
    private int ticketCount;
    private int dislikeCount;

    @Builder
    public User(String ssaId, String nickname, int ticketCount, int dislikeCount) {
        this.ssaId = ssaId;
        this.nickname = nickname;
        this.ticketCount = ticketCount;
        this.dislikeCount = dislikeCount;
    }
}