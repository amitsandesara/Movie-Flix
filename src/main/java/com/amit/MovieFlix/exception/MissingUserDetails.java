package com.amit.MovieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Missing user details")
public class MissingUserDetails extends RuntimeException{

	private static final long serialVersionUID = -2247398183582789652L;
	
	public MissingUserDetails(String msg){
		super(msg);
	}
	
	public MissingUserDetails(String msg, Throwable cause){
		super(msg, cause);
	}
}
