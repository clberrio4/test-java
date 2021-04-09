package com.cesar_dev.rest_api.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesar_dev.rest_api.persistence.entity.Customer;

public interface CustomerCrudRepository extends JpaRepository<Customer, Integer> {
	
	Optional<Customer> findByEmailEqualsOrDocumentEquals(String email, String document);
	Optional<Customer> findByEmailEquals(String email);
}
