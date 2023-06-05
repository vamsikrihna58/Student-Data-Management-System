package com.org.StudentDataManagementSystem.ResponseStructure;

import lombok.Data;

@Data
public class ResponseStructure <T>{
	private Integer statusCode;
	private T data;
	private String message;

}
