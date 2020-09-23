package com.capg.greatoutdoor.usermanagement.exceptions;

public class UserPasswordInvalidException extends RuntimeException {
    public UserPasswordInvalidException(String message)
    {
    	super(message);
    }
}
