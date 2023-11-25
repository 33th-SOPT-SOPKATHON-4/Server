package org.sopkaton.Project.common.exception;

import lombok.Getter;
import org.sopkaton.Project.common.dto.Error;

@Getter
public class CustomException extends RuntimeException{
	private final Error error;

	public CustomException(Error error, String message) {
		super(message);
		this.error = error;
	}

	public int getHttpStatus() {
		return error.getErrorCode();
	}
}
