package com.cesar_dev.rest_api.persistence.entity.dto;

public class OrderDto extends BaseEntityDto {
	private Integer id;
	private String code;
	private Float iva;
	private Double total;
	private double subtotal = 0;
	private double deliveryPrice;
	private OrderStatusDto status;
	private CustomerDto customer;

	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public Float getIva() {
		return iva;
	}

	public Double getTotal() {
		return total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getDeliveryPrice() {
		return deliveryPrice;
	}

	public OrderStatusDto getStatus() {
		return status;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setIva(Float iva) {
		this.iva = iva;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public void setStatus(OrderStatusDto status) {
		this.status = status;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

}
