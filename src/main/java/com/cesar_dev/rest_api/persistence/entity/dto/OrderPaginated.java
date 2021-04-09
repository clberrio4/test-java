package com.cesar_dev.rest_api.persistence.entity.dto;

import java.util.List;

public class OrderPaginated {

	private List<OrderDto> orders;
	private boolean hasNext;
	private boolean hasPrevious;
	private  int totalPages;
	private int currentPage;
	public List<OrderDto> getOrders() {
		return orders;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}
