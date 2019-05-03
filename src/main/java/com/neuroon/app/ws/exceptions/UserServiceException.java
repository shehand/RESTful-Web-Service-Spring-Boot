package com.neuroon.app.ws.exceptions;

public class UserServiceException extends RuntimeException{

	private static final long serialVersionUID = 3279840583482754871L;
	
	public UserServiceException(String message) {
		super(message);
	}

}
