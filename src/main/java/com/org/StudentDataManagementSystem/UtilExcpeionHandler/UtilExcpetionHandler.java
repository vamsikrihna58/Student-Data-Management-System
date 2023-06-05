package com.org.StudentDataManagementSystem.UtilExcpeionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.StudentDataManagementSystem.ResponseStructure.ResponseStructure;


@RestControllerAdvice
public class UtilExcpetionHandler {
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handler(NoDataFoundException ie)
	{
		ResponseStructure<String> re=new ResponseStructure<>();
		re.setStatusCode(HttpStatus.NOT_FOUND.value());
		re.setData(ie.getMessage());
		re.setMessage("No Data Found For you are Search");
		return new ResponseEntity<ResponseStructure<String>>(re,HttpStatus.NOT_FOUND);
	}
}


