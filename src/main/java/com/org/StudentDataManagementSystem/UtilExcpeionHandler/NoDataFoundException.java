package com.org.StudentDataManagementSystem.UtilExcpeionHandler;

public class NoDataFoundException extends RuntimeException{
	private String message ="No data Found";
	@Override
	public String getMessage() {
		return message;
	}

}
