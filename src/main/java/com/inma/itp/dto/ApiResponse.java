package com.inma.itp.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inma.itp.exception.ErrorType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ApiResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	private int status;
	private String message;
	private Long createdId;
	List<String> errors;

	private ApiResponse() {
		timestamp = LocalDateTime.now();
		errors = new ArrayList<String>();
	}

	public ApiResponse(int status, String message) {
		this();
		this.status = status;
		this.message = message;
	}

	public ApiResponse(int status, ErrorType errorType) {
		this();
		this.status = status;
		this.message = errorType.toString();
	}

	public ApiResponse(HttpStatus status, String message) {
		this();
		this.status = status.ordinal();
		this.message = message;
	}

	public void addError(String error) {
		this.errors.add(error);
	}

}
