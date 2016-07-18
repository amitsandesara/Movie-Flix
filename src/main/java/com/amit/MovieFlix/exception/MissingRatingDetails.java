package com.amit.MovieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Rating cannot be null and must be between 1 and 5")
public class MissingRatingDetails extends RuntimeException{

	private static final long serialVersionUID = -8523524755382917755L;

	public MissingRatingDetails(String msg){
		super(msg);
	}
	
	public MissingRatingDetails(String msg, Throwable cause){
		super(msg, cause);
	}
}
