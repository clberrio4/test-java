package com.cesar_dev.rest_api.persistence.entity.dto;

public class OrderStatusDto extends BaseEntityDto{
	
	private Integer id;
	private String status;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public String getDescription() {
		return description;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
