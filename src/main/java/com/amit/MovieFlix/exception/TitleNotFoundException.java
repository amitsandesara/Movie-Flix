package com.amit.MovieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="No titles with specified information found")
public class TitleNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 7091055949150404194L;

	public TitleNotFoundException(String msg){
		super(msg);
	}

	public TitleNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
