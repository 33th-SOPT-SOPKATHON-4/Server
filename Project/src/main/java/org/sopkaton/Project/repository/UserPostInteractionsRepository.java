package org.sopkaton.Project.repository;

import org.sopkaton.Project.domain.User;
import org.sopkaton.Project.domain.UserPostInteractions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPostInteractionsRepository extends JpaRepository<UserPostInteractions, Long> {

    @Query("SELECT upi.postId FROM UserPostInteractions upi WHERE upi.ssaId = :ssaId")
    List<Long> findDislikePostByUser(String ssaId);
}
