package com.mta.javacourse.exceptions;

public class BalanceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BalanceException() {
		super("Out of balance!");
	}
	
	public BalanceException(String message) {
		super(message);
	}

}
