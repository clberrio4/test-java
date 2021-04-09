package com.cesar_dev.rest_api.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesar_dev.rest_api.persistence.entity.Product;

public interface ProductCrudRepository extends JpaRepository<Product, Integer> {
	Optional<Product> findByCode(String code);
}
