package com.cesar_dev.rest_api.service.interfaz;

import java.util.List;

import com.cesar_dev.rest_api.persistence.entity.dto.OrderDetailDto;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDto;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;

public interface IOrderService {
	OrderPaginated getOrders(int page, int size);

	List<OrderDto> getOrdersByCustomer(int customerId);

	ResponseData saveOrder(OrderDto order);

	ResponseData updateOrder(OrderDto order, int id);

	ResponseData updateOrderByCode(String code, OrderDto order);

	ResponseData deleteOrder(int orderId);

	ResponseData deleteOrderByCode(String code);

	ResponseData addOrderDetail(OrderDetailDto orders, String orderCode);

	ResponseData addOrderDetails(List<OrderDetailDto> orders, String orderCode);

	ResponseData cancelOrder(String orderCode);

}
