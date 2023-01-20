package com.onlinefooddeliveryapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerException(CustomerException customerException, WebRequest req){
		
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), customerException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerLoginException.class)
	public ResponseEntity<MyErrorDetails> customerException(CustomerLoginException customerLoginException, WebRequest req){
		
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), customerLoginException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails> restaurantException(RestaurantException restaurantException, WebRequest req){
		
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), restaurantException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails> itemException(ItemException itemException, WebRequest req){
		
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), itemException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> categoryException(CategoryException categoryException, WebRequest req){
		
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), categoryException.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception exception,WebRequest req){
		
		MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), exception.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException noHandlerFoundException,WebRequest req)  {
			
	
	MyErrorDetails myErr =new MyErrorDetails(LocalDateTime.now(), noHandlerFoundException.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
					
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException,WebRequest req)  {
			
	
	MyErrorDetails myErr=new MyErrorDetails(LocalDateTime.now(), methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
					
	}

	

}
