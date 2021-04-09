package com.cesar_dev.rest_api.persistence.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product extends BaseEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code,name,description;
	private Integer stock;
	private Double price;
	
	@OneToMany(mappedBy ="products" ,cascade = {CascadeType.ALL})
	private Set<OrderDetail> orderDetail;
	
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
	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	
}
