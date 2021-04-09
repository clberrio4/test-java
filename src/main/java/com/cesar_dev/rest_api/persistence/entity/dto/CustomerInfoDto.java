package com.cesar_dev.rest_api.persistence.entity.dto;


public class CustomerInfoDto extends BaseEntityDto{

	private Integer id;
	private String address;
	private String phone;

	public Integer getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
