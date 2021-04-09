package com.cesar_dev.rest_api.persistence.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	 @Column(unique = true)
	 private String document;
	 
	 private String name;
	 
	 @Column(unique = true)
	 private String email;
	 
	 private String password;
	 
	 @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 private List<CustomerInfo> info;
	 
	 @OneToMany(mappedBy = "customer")
	 private List<Order> orders;
	 
	public List<CustomerInfo> getCustomer() {
		return info;
	}
	public void setCustomer(List<CustomerInfo> customer) {
		this.info = customer;
	}
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
	public List<CustomerInfo> getInfo() {
		return info;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setInfo(List<CustomerInfo> info) {
		this.info = info;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	 
	  
}
