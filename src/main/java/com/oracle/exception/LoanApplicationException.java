package com.oracle.exception;

public class LoanApplicationException extends RuntimeException {
	public LoanApplicationException() {
	}
	public LoanApplicationException(String msg) {
		super(msg);
	}
}
