package com.github.devmribeiro.bookinghub.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptinoHandler {

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorMessage> invalidInputException(InvalidInputException ex, WebRequest request) {
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						HttpStatus.BAD_REQUEST.value(),
						LocalDateTime.now(),
						ex.getMessage(),
						request.getDescription(false)
			),
			HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		return new ResponseEntity<ErrorMessage>(
				new ErrorMessage(
						HttpStatus.NOT_FOUND.value(),
						LocalDateTime.now(),
						ex.getMessage(),
						request.getDescription(false)
			),
			HttpStatus.NOT_FOUND
		);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorMessage> httpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
		return new ResponseEntity<>(
			new ErrorMessage(
				HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now(),
				"Invalid or missing request body",
				request.getDescription(false)
			),
			HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGeneralException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(
			new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now(),
				"An unexpected error occurred",
				request.getDescription(false)
			),
			HttpStatus.INTERNAL_SERVER_ERROR
		);
	}
}