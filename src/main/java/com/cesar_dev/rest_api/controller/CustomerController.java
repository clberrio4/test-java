package com.cesar_dev.rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cesar_dev.rest_api.persistence.entity.dto.CustomerDto;
import com.cesar_dev.rest_api.persistence.entity.dto.CustomerPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;
import com.cesar_dev.rest_api.service.interfaz.ICustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService _customerService;
	
	@GetMapping
	CustomerPaginated findCustomer(@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size",defaultValue = "10") int size) {
		return _customerService.getCustomers(page, size);	
	}
	
	@PostMapping
	ResponseData saveCustomer(@RequestBody(required = true) CustomerDto customer) {
		return _customerService.saveCustomer(customer);
	}
	
	@PutMapping(path = "/{id}")
	ResponseData updateCustomer(@RequestBody(required = true) CustomerDto customer, @PathVariable(name = "id")int id) {
		return _customerService.updateCustomer(customer,id);
	}
}
