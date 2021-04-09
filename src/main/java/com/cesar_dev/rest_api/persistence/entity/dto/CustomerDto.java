package com.cesar_dev.rest_api.persistence.entity.dto;

import java.util.List;

public class CustomerDto extends BaseEntityDto {
	 private Integer id;
	 
	 private String document;
	 
	 private String name;
	 
	 private String email;
	 
	 private String password;
	 
	 private List<CustomerInfoDto> info;

	public Integer getId() {
		return id;
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<CustomerInfoDto> getInfo() {
		return info;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setInfo(List<CustomerInfoDto> info) {
		this.info = info;
	}
	 
	 
}
