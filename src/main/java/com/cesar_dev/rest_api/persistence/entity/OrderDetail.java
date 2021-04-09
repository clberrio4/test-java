package com.cesar_dev.rest_api.persistence.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cesar_dev.rest_api.persistence.entity.compositeKey.OrderDetailPK;

@Entity
@Table(name="order_details")
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	@EmbeddedId
	private OrderDetailPK id;
	
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "product_id", updatable = false,insertable = false)
	private Product products;
	
	@ManyToOne
	@JoinColumn(name = "order_id",insertable = false, updatable = false)
	private Order orders;

	public Integer getQuantity() {
		return quantity;
	}

	public Product getProducts() {
		return products;
	}

	public Order getOrders() {
		return orders;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public OrderDetailPK getId() {
		return id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

}
