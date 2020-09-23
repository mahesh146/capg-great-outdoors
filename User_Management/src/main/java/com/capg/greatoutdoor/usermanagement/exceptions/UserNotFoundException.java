package com.capg.greatoutdoor.usermanagement.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message)
	{
		super(message);
	}
	public UserNotFoundException()
	{
		super();
	}
}
