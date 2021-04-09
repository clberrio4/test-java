package com.cesar_dev.rest_api.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.cesar_dev.rest_api.persistence.entity.Customer;
import com.cesar_dev.rest_api.persistence.entity.dto.CustomerDto;
import com.cesar_dev.rest_api.persistence.entity.dto.CustomerPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;
import com.cesar_dev.rest_api.persistence.entity.mapper.CustomerMapper;
import com.cesar_dev.rest_api.repository.crud.CustomerCrudRepository;

@Repository
public class CustomerRepository {

	@Autowired
	private CustomerCrudRepository _crudRepository;

	@Autowired
	private CustomerMapper _customerMapper;

	public Optional<Customer> getCustomerByEmail(String email, String document) {
		return _crudRepository.findByEmailEqualsOrDocumentEquals(email, document);
	}

	public ResponseData saveCustomer(Customer customer) {
		boolean status = this.getCustomerByEmail(customer.getEmail(), customer.getDocument()).map(c -> {
			return true;
		}).orElse(false);

		if (status) {
			return new ResponseData("customer has been took", false);
		}

		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedAt(LocalDateTime.now());

		_crudRepository.save(customer);

		return new ResponseData("customer saved", true);
	}

	public ResponseData updateCustomer(Customer customer, int id) {
		Customer customerToUpdate = _crudRepository.findById(id).get();
		customer.setId(customerToUpdate.getId());
		_crudRepository.save(customer);
		return new ResponseData("customer updated", true);
	}

	public CustomerPaginated getAllCustomers(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Customer> customerPaginated = _crudRepository.findAll(pageRequest);
		CustomerPaginated customers = new CustomerPaginated();

		if (customerPaginated.hasContent()) {
			List<CustomerDto> cusTemp = customerPaginated.getContent().stream().map(x -> {
				return _customerMapper.toCustomerDto(x);
			}).collect(Collectors.toList());
			customers.setCustomers(cusTemp);
			customers.setHasNext(customerPaginated.hasNext());
			customers.setTotal(customerPaginated.getTotalPages());
			customers.setHasPrevious(customerPaginated.hasPrevious());
			customers.setCurrent(page);
			return customers;
		}
		return customers;
	}

}
