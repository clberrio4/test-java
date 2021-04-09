package com.cesar_dev.rest_api.service.interfaz;


import com.cesar_dev.rest_api.persistence.entity.dto.CustomerDto;
import com.cesar_dev.rest_api.persistence.entity.dto.CustomerPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;

public interface ICustomerService {

	CustomerPaginated getCustomers(int page,int size);
	ResponseData saveCustomer(CustomerDto customer);
	ResponseData updateCustomer(CustomerDto customer, int id);
	
}
