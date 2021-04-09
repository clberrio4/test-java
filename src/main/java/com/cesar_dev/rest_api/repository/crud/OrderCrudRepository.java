package com.cesar_dev.rest_api.repository.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesar_dev.rest_api.persistence.entity.Order;

public interface OrderCrudRepository extends JpaRepository<Order, Integer>  {
	Optional<List<Order>> findByCustomerId(int customerId);
	Optional<Order> findOneByCode(String code);
}
