package com.capg.greatoutdoor.usermanagement.exceptions;

public class UserNameAlreadyExistException extends RuntimeException {

	public  UserNameAlreadyExistException(String message)
	{
		super(message);
	}
}
