package com.cesar_dev.rest_api.persistence.entity.dto;

public class ResponseData {
	
	public ResponseData(String message, boolean status) {
		this.message=message;
		this.status=status;
	}
	public ResponseData() {
		
	}
	
	public String message;
	public boolean status;
}
