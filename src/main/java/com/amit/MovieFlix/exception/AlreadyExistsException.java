package com.amit.MovieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Attempt to create object which already exists")
public class AlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlreadyExistsException(String msg) {
		super(msg);
	}

	public AlreadyExistsException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
