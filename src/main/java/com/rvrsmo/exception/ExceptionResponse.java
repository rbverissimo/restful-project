package com.rvrsmo.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	//ExceptionResponse returns a JSON with Exception information
	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timestamp, 
			String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	} 
	
	
	
	
}