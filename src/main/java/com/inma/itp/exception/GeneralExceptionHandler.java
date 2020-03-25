package com.inma.itp.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.inma.itp.dto.ApiResponse;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {

		System.out.println(">>>>>>>>>Request Body Exception<<<<<<<<<<");
		// Get all errors
		List<String> errors = ex
				.getConstraintViolations().stream().map(x -> String.format("%s value '%s' %s",
						((PathImpl) x.getPropertyPath()).getLeafNode().getName(), x.getInvalidValue(), x.getMessage()))
				.collect(Collectors.toList());

		System.out.println(errors);

		ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST.value(), ErrorType.ValidationError);
		response.setErrors(errors);

		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { InvalidUsernamePasswordException.class })
	public ResponseEntity<Object> unAuthorised(InvalidUsernamePasswordException ex) {

		System.out.println(">>>>>>>>>InvalidUsernamePassword Exception<<<<<<<<<<");
		ApiResponse response = new ApiResponse(401, ErrorType.BusinessValidationError);
		response.addError(ex.getMessage());

		return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = { ResourceAlreadyExistException.class })
	protected ResponseEntity<Object> handleConstraintViolationException(ResourceAlreadyExistException ex,
			WebRequest request) {

		System.out.println(">>>>>>>>>Resource Already Exist Exception<<<<<<<<<<");
		// Get all errors

		ApiResponse response = new ApiResponse(HttpStatus.BAD_REQUEST.value(), ErrorType.BusinessValidationError);
		response.addError(ex.getMessage());

		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	protected ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex, WebRequest request) {

		System.out.println(">>>>>>>>>Resource Not Found Exception<<<<<<<<<<");
		// Get all errors

		ApiResponse response = new ApiResponse(HttpStatus.NOT_FOUND.value(), ErrorType.BusinessValidationError);
		response.addError(ex.getMessage());

		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		ApiResponse response = new ApiResponse(status.value(), ErrorType.ValidationError);
		response.setErrors(errors);

		return new ResponseEntity<>(response, headers, status);
	}

}
