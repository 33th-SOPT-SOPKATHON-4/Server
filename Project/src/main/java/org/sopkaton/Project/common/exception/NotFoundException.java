package org.sopkaton.Project.common.exception;

import org.sopkaton.Project.common.dto.Error;

public class NotFoundException extends CustomException {
	public NotFoundException(Error error, String message) {
		super(error, message);
	}
}
