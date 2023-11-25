package org.sopkaton.Project.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postImg;
    private String postContent;
    private int postDislikeCount;
    private String createdDateTime;

    @ManyToOne
    @JoinColumn(name = "ssaId")
    private User user;

    @Builder
    public Post(Long postId, String postImg, String postContent, int postDislikeCount, String createdDateTime, User user) {
        this.postId = postId;
        this.postImg = postImg;
        this.postContent = postContent;
        this.postDislikeCount = postDislikeCount;
        this.createdDateTime = createdDateTime;
        this.user = user;
    }
}