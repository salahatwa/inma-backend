package com.inma.itp.exception;

public enum ErrorType {
	BusinessError("1"), ValidationError("2"),BusinessValidationError("3");

	ErrorType(String errorType) {
		this.errorType = errorType;
	}

	private String errorType;

	@Override
	public String toString() {
		return errorType;
	}
}
