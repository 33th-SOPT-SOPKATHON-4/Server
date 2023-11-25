package org.sopkaton.Project.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum Success {

	/**
	 * 201 CREATED
	 */
	CREATE_SUCCESS(HttpStatus.CREATED, "유저 로그인 성공"),
  
	DISLIKE_POST_SUCCESS(HttpStatus.OK, "게시물 질투나요 성공"),
  
	CREATE_USER_SUCCESS(HttpStatus.CREATED, "유저 로그인 성공"),

	/**
	 * 201 CREATED
	 */
	CREATE_POST_SUCCESS(HttpStatus.CREATED, "게시물 생성 성공"),
	/**
	 * 200 OK
	 */

	GET_USER_SUCCESS(HttpStatus.OK, "유저 조회 성공"),
  
	/**
	 * 200 OK
	 */
	GET_SUCCESS(HttpStatus.OK, "조회 성공"),
  
	GET_POST_SUCCESS(HttpStatus.OK, "게시글 조회 성공"),

	/**
	 * 204 NO_CONTENT
	 */

	;

	private final HttpStatus httpStatus;
	private final String message;

	public int getHttpStatusCode(){
		return httpStatus.value();
	}

}
