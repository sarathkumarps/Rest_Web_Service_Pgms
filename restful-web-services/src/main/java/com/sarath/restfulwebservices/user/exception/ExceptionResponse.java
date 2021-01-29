package com.sarath.restfulwebservices.user.exception;

import java.util.Date;

public class ExceptionResponse  {
	
	//timestamp
	//message
	//details
	
	private Date timestamp;
	private String name;
	private String details;
	public ExceptionResponse(Date timestamp, String name, String details) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getName() {
		return name;
	}
	public String getDetails() {
		return details;
	}

}
