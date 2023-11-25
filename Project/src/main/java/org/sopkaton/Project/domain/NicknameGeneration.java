package org.sopkaton.Project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NicknameGeneration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ngId;

    private String first_name;
    private String second_name;

}
