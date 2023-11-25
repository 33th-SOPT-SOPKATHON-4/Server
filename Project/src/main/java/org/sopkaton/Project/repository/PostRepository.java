package org.sopkaton.Project.repository;

import org.sopkaton.Project.domain.Post;
import org.sopkaton.Project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.user = :user")
    List<Post> findPostIdByUser(User user);

    @Modifying
    @Query("UPDATE Post p SET p.postDislikeCount = p.postDislikeCount +1 WHERE p.postId = :postId")
    void updateDislikeCount(@Param("postId") Long postId);

    List<Post> findByUser(User user);

}
