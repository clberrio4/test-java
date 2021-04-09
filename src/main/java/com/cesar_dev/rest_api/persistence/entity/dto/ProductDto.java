package com.cesar_dev.rest_api.persistence.entity.dto;



public class ProductDto extends BaseEntityDto{
	private Integer id;
	private String code,name,description;
	private Integer stock;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private Double price;
	
	public Integer getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Integer getStock() {
		return stock;
	}
	public Double getPrice() {
		return price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
