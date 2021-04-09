package com.cesar_dev.rest_api.repository.crud;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesar_dev.rest_api.persistence.entity.OrderDetail;
import com.cesar_dev.rest_api.persistence.entity.compositeKey.OrderDetailPK;

public interface OrderDetailCrudRepository extends JpaRepository<OrderDetail, OrderDetailPK>{
	Optional<OrderDetail> findByIdOrderId(int orderId);
	Optional<List<OrderDetail>> findDistinctByIdOrderId(int orderId);
}
