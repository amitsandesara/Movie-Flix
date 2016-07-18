package com.amit.MovieFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE, reason="Password is empty, User cannot be created")
public class PasswordException extends RuntimeException{

	private static final long serialVersionUID = 2899252375412463751L;

	public PasswordException(String msg){
		super(msg);
	}
	
	public PasswordException(String msg, Throwable cause){
		super(msg,cause);
	}
}
