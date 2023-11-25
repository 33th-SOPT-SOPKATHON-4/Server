package org.sopkaton.Project.repository;

import org.sopkaton.Project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
