package com.student.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.student.model.StudentExceptionDetails;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<StudentExceptionDetails> studentExceptionDetails(Exception e, WebRequest request){
		
		StudentExceptionDetails entity = new StudentExceptionDetails(LocalDate.now(), e.getMessage(), request.getDescription(false));
		return new ResponseEntity<StudentExceptionDetails>(entity,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<StudentExceptionDetails> noHandlerFoundException(NoHandlerFoundException n,WebRequest request){
		return new ResponseEntity<StudentExceptionDetails>(new StudentExceptionDetails(LocalDate.now(),n.getMessage(),request.getDescription(false)), HttpStatus.BAD_REQUEST);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StudentExceptionDetails> methodArgumentsNotValid(MethodArgumentNotValidException e,WebRequest request){
		
		return new ResponseEntity<StudentExceptionDetails>(new StudentExceptionDetails(LocalDate.now(),e.getMessage(),request.getDescription(false)),HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
