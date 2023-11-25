package org.sopkaton.Project.repository;

import org.sopkaton.Project.domain.NicknameGeneration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NicknameGenerationJpaRepository extends JpaRepository<NicknameGeneration, String> {
}
