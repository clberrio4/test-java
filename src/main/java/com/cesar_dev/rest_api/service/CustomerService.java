package com.cesar_dev.rest_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cesar_dev.rest_api.persistence.entity.Customer;
import com.cesar_dev.rest_api.persistence.entity.dto.CustomerDto;
import com.cesar_dev.rest_api.persistence.entity.dto.CustomerPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;
import com.cesar_dev.rest_api.persistence.entity.mapper.CustomerMapper;
import com.cesar_dev.rest_api.repository.CustomerRepository;
import com.cesar_dev.rest_api.repository.crud.CustomerCrudRepository;
import com.cesar_dev.rest_api.service.interfaz.ICustomerService;

@Service
public class CustomerService implements ICustomerService  {

	@Autowired
	private CustomerCrudRepository _customerRep;
	@Autowired
	private CustomerMapper _customerMapper;
	
	@Autowired
	private CustomerRepository _customerRepo;
	
	@Override
	public CustomerPaginated getCustomers(int page,int size) {
		PageRequest pageRequest =PageRequest.of(page, size);
		Page<Customer> customerPaginated =_customerRep.findAll(pageRequest);
		CustomerPaginated customers= new CustomerPaginated();
		
		if(customerPaginated.hasContent()) {
			List<CustomerDto> cusTemp =customerPaginated.getContent().stream().map(x->{return _customerMapper.toCustomerDto(x);}).collect(Collectors.toList());
			customers.setCustomers(cusTemp);
			customers.setHasNext(customerPaginated.hasNext());
			customers.setTotal(customerPaginated.getTotalPages());
			customers.setHasPrevious(customerPaginated.hasPrevious());
			customers.setCurrent(page);
			return customers;
		}
		return customers;
	}
	
	@Override
	public ResponseData saveCustomer(CustomerDto customer) {
		return _customerRepo.saveCustomer(_customerMapper.toCustomer(customer));
	}

	@Override
	public ResponseData updateCustomer(CustomerDto customer, int id) {
		return _customerRepo.updateCustomer(_customerMapper.toCustomer(customer), id);
	}


	
}
