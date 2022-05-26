package com.sujitmaity.project.upi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralException {
	Logger LOGGER=LoggerFactory.getLogger("CentralException.class");
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UpiIdDoesNotExistException.class)
	public String UserIdDoesNotExistException(UpiIdDoesNotExistException e) {
		System.out.println("UpiId DoesNot Exist in Database");
		LOGGER.info("{} UpiIdDoesNotExistException",e.getMessage());
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UpiIdInValidException.class)
	public String EmailIdInValidException(UpiIdInValidException e) {
		System.out.println("Invalid UpiId");
		LOGGER.info("{} UpiIdInValidException",e.getMessage());
		return e.getMessage();
}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PhoneNumberInvalidException.class)
	public String PhoneNumberInvalidException(PhoneNumberInvalidException e) {
		System.out.println("Invalid PhoneNumber");
		LOGGER.info("PhoneNumberInvalidException",e.getMessage());
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailIdInValidException.class)
	public String EmailIdInValidException(EmailIdInValidException e) {
		System.out.println("Invalid EmailId");
		LOGGER.info("EmailIdInValidException",e.getMessage());
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserIdIsNotPresentException.class)
	public String UserIdIsNotPresentException(UserIdIsNotPresentException e) {
		System.out.println("UPI-Id Doesnot Exist in Database");
		LOGGER.info("UserIdIsNotPresentException",e.getMessage());
		return e.getMessage();
	}
}