package com.cesar_dev.rest_api.persistence.entity.dto;

import com.cesar_dev.rest_api.persistence.entity.Order;
import com.cesar_dev.rest_api.persistence.entity.Product;
import com.cesar_dev.rest_api.persistence.entity.compositeKey.OrderDetailPK;

public class OrderDetailDto extends BaseEntityDto {
	private OrderDetailPK id;
	private int orderId;
	private int productId;
	private Integer quantity;
	private Product products;
	private Order order;

	public Integer getQuantity() {
		return quantity;
	}

	public Product getProducts() {
		return products;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public OrderDetailPK getId() {
		return id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

	
}
