package org.sopkaton.Project.service;

import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.domain.Post;
import org.sopkaton.Project.domain.User;
import org.sopkaton.Project.dto.response.UserGetResponse;
import org.sopkaton.Project.dto.response.UserPostGetResponse;
import org.sopkaton.Project.repository.NicknameGenerationJpaRepository;
import org.sopkaton.Project.repository.PostRepository;
import org.sopkaton.Project.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final PostRepository postRepository;
    private final NicknameGenerationJpaRepository nicknameGenerationJpaRepository;

    private final int NICKNAME_NUM = 5;

    @Transactional
    public UserGetResponse login(String ssaId){
        User user = userJpaRepository.findById(ssaId)
                .orElseGet(() -> createUser(ssaId));

        return UserGetResponse.of(user);
    }

    public UserPostGetResponse getUserBySsaId(String ssaId){
        User user = userJpaRepository.findById(ssaId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. ssaId = " + ssaId));

        List<Post> posts = postRepository.findByUser(userJpaRepository.findById(ssaId).get());

        // createdDateTime을 기준으로 내림차순으로 정렬하는 Comparator 생성
        Comparator<Post> dateTimeComparator = Comparator.comparing(Post::getCreatedDateTime).reversed();

        // 리스트를 createdDateTime을 기준으로 내림차순으로 정렬
        Collections.sort(posts, dateTimeComparator);

        return UserPostGetResponse.of(user, posts);
    }

    private User createUser(String ssaId){
        User user = userJpaRepository.save(User.builder().ssaId(ssaId)
                .nickname(makeNickname())
                .ticketCount(0)
                .dislikeCount(0).build());

        return user;
    }

    private String makeNickname(){
        // Random 객체 생성
        Random random = new Random();

        int randomNumber = random.nextInt(NICKNAME_NUM) + 1;

        String firstName = nicknameGenerationJpaRepository.findById(String.valueOf(randomNumber)).get().getFirst_name();
        String secondName = nicknameGenerationJpaRepository.findById(String.valueOf(randomNumber)).get().getSecond_name();

        return firstName + " " + secondName;
    }
}
