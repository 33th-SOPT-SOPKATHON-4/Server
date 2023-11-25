package org.sopkaton.Project.repository;

import org.sopkaton.Project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, String> {
}
