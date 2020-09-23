/**
	
	*
	* 
**/


package com.capg.greatoutdoor.wishlistmanagement.controller;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.greatoutdoor.wishlistmanagement.exceptions.ErrorInfo;
import com.capg.greatoutdoor.wishlistmanagement.exceptions.ProductAlreadyExistsException;
import com.capg.greatoutdoor.wishlistmanagement.exceptions.UserDoesnotExistsException;




@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {ProductAlreadyExistsException.class})	public ErrorInfo handleCenterAlreadyExistsException(ProductAlreadyExistsException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {UserDoesnotExistsException.class})
	public ErrorInfo handleSpecifiedCenterDoesnotExistException(UserDoesnotExistsException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	

}
