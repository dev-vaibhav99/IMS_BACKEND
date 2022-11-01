package com.career.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.student.controller.StudentController;

@RestControllerAdvice(basePackageClasses = StudentController.class)
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ResponseDto> handleEmailAlreadyExistsException() {
		return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.EMAIL_ALREADY_EXISTS,
				HttpStatus.CONFLICT.value(), LocalDateTime.now().toString()), HttpStatus.CONFLICT);
	}

}
