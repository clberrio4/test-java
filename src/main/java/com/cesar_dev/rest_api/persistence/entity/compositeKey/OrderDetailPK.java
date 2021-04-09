package com.cesar_dev.rest_api.persistence.entity.compositeKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPK implements Serializable {
	
	public OrderDetailPK(Integer orderId, Integer productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}
	
	
	public OrderDetailPK() {
		super();
	}


	private static final long serialVersionUID = 1L;

	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	public Integer getOrderId() {
		return orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
}
