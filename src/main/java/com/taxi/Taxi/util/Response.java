package com.taxi.Taxi.util;


import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Response {

	private Date timestamp;
	private String message;
	private HttpStatus status;
	private Object data;

	public Response() {
	
	}

	public Response(Date timestamp, String message, HttpStatus status, Object data) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public Response(Date timestamp, String message, HttpStatus status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}
	
	/*public Response(Date timestamp, String message, HttpStatus status, Object data) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.data = data;
	}*/

	

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
