package com.bitwise.shop.models;

public class OutOfStockException extends RuntimeException {
	String exceptionMsg;

	public OutOfStockException() {

	}

	public OutOfStockException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}
