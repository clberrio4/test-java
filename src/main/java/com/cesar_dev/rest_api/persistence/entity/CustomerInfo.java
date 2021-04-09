package com.cesar_dev.rest_api.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_info")
public class CustomerInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String address;
	private String phone;
	
	@ManyToOne()
	@JoinColumn (name = "customer_id",insertable = false,updatable = false)
	private  Customer customer;
	
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
	public Customer getInfo() {
		return customer;
	}
	public void setInfo(Customer customer) {
		this.customer=customer;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
