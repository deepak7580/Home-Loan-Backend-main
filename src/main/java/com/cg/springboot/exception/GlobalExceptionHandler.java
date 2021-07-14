package com.cg.springboot.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(CustomerNotFoundException exception,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(InvalidLoanAgreementException.class)
	public ResponseEntity<?> handleInvalidLoanAgrementException(InvalidLoanAgreementException ex,WebRequest request) {
		
		
		ErrorDetails errorDetails=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>handleValidationErrorException( MethodArgumentNotValidException exception){
		ErrorDetails errorDetails= new ErrorDetails(new Date(),"Validation error", exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
				
	}
	

}
