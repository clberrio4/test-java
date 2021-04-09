package com.cesar_dev.rest_api.persistence.entity.dto;

import java.util.List;

public class CustomerPaginated {
	private List<CustomerDto> customers;
	private boolean hasNext;
	private boolean hasPrevious;
	private  int totalPages;
	private int currentPage;
	
	public List<CustomerDto> getCustomers() {
		return customers;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public boolean isHasPrevious() {
		return hasPrevious;
	}
	public int getTotal() {
		return totalPages;
	}
	public int getCurrent() {
		return currentPage;
	}
	public void setCustomers(List<CustomerDto> customers) {
		this.customers = customers;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	public void setTotal(int total) {
		this.totalPages = total;
	}
	public void setCurrent(int current) {
		this.currentPage = current;
	}
	
}
