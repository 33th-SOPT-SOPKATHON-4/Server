package org.sopkaton.Project.service;

import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.domain.User;
import org.sopkaton.Project.dto.response.UserGetResponse;
import org.sopkaton.Project.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserJpaRepository userJpaRepository;

    public UserGetResponse login(String ssaId){
        User user = userJpaRepository.findById(ssaId)
                .orElseGet(() -> createUser(ssaId));

        return UserGetResponse.of(user);

    }

    private User createUser(String ssaId){
        User user = userJpaRepository.save(User.builder().ssaId(ssaId)
                .nickname("따뜻한 코알라")
                .ticketCount(0)
                .dislikeCount(0).build());

        return user;
    }
}
