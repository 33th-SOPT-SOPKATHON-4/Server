package org.sopkaton.Project.service;

import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.domain.User;
import org.sopkaton.Project.dto.response.UserGetResponse;
import org.sopkaton.Project.repository.NicknameGenerationJpaRepository;
import org.sopkaton.Project.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserJpaRepository userJpaRepository;
    private final NicknameGenerationJpaRepository nicknameGenerationJpaRepository;

    private final int NICKNAME_NUM = 5;

    @Transactional
    public UserGetResponse login(String ssaId){
        User user = userJpaRepository.findById(ssaId)
                .orElseGet(() -> createUser(ssaId));

        return UserGetResponse.of(user);

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
