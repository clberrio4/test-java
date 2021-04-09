package com.cesar_dev.rest_api.persistence.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private Float iva;
	private Double total;

	@Column(name = "sub_total")
	private double subtotal;

	@Column(name = "delivery_price")
	private double deliveryPrice;

	@OneToMany(mappedBy = "orders", cascade = { CascadeType.ALL })
	private Set<OrderDetail> orderDetails;

	@ManyToOne()
	@JoinColumn(name = "order_status", insertable = true, updatable = true)
	private OrderStatus status;

	@ManyToOne()
	@JoinColumn(name = "customer_id", insertable = true, updatable = true)
	private Customer customer;

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Integer getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public Float getIva() {
		return iva;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public Double getTotal() {
		return total;
	}

	public Double getDeliveryPrice() {
		return deliveryPrice;
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

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
