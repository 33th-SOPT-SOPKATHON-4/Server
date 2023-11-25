package org.sopkaton.Project.repository;

import org.sopkaton.Project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Modifying
    @Query("UPDATE User u SET u.dislikeCount =u.dislikeCount+1 WHERE u.ssaId=:ssaId")
    void updateDislikeCount(@Param("ssaId") String ssaId);
}
