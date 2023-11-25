package org.sopkaton.Project.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserPostInteractions {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long upiId;

    String ssaId;
    Long postId;

    @Builder
    UserPostInteractions(String ssaId, Long postId){
        this.ssaId = ssaId;
        this.postId=postId;
    }
}
