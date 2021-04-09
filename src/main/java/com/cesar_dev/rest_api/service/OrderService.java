package com.cesar_dev.rest_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDetailDto;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDto;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;
import com.cesar_dev.rest_api.persistence.entity.mapper.OrderDetailMappper;
import com.cesar_dev.rest_api.persistence.entity.mapper.OrderMapper;
import com.cesar_dev.rest_api.repository.OrderDetailRepository;
import com.cesar_dev.rest_api.repository.OrderRepository;
import com.cesar_dev.rest_api.service.interfaz.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderMapper _orderMapper;

	@Autowired
	private OrderRepository _orderRepo;

	@Autowired
	private OrderDetailRepository _orderDetailRepo;

	@Override
	public OrderPaginated getOrders(int page, int size) {
		_orderRepo.findAll(page, size);
		return _orderRepo.findAll(page, size);
	}

	@Override
	public List<OrderDto> getOrdersByCustomer(int customerId) {
		return _orderRepo.findByCustomerId(customerId);
	}

	@Override
	public ResponseData saveOrder(OrderDto order) {
		if (_orderRepo.saveOrder(_orderMapper.toOrder(order))) {
			return new ResponseData("order create", true);
		}
		return new ResponseData("can't create order", false);
	}

	@Override
	public ResponseData updateOrder(OrderDto order, int id) {

		if (_orderRepo.updateOrder(_orderMapper.toOrder(order), id)) {
			return new ResponseData("order udpated", true);
		}
		return new ResponseData("order can't be updated", false);
	}

	@Override
	public ResponseData deleteOrder(int orderId) {
		if (_orderRepo.deleteOrder(orderId)) {
			return new ResponseData("order deleted", true);
		}
		return new ResponseData("order can't be deleted", false);
	}

	@Override
	public ResponseData deleteOrderByCode(String code) {
		if (_orderRepo.deleteOrderByCode(code)) {
			return new ResponseData("order deleted", true);
		}

		return new ResponseData("deleted", false);
	}

	@Override
	public ResponseData updateOrderByCode(String code, OrderDto order) {
		if (_orderRepo.updateOrderByCode(_orderMapper.toOrder(order), code)) {
			return new ResponseData("order updated", true);
		}
		return new ResponseData("order can't be updated", false);
	}

	@Override
	public ResponseData addOrderDetail(OrderDetailDto orders, String orderCode) {

		return new ResponseData(_orderDetailRepo.addProductToShop(orders, orderCode), true);
	}

	@Override
	public ResponseData cancelOrder(String orderCode) {
		return new ResponseData(_orderDetailRepo.cancelOrder(orderCode), true);

	}

	@Override
	public ResponseData addOrderDetails(List<OrderDetailDto> orders, String orderCode) {
		return new ResponseData(_orderDetailRepo.addManyOrders(orders, orderCode), true);
	}

}
