package com.cesar_dev.rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDetailDto;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDto;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;
import com.cesar_dev.rest_api.service.interfaz.IOrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private IOrderService _orderSer;

	@GetMapping
	OrderPaginated getOrders(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return _orderSer.getOrders(page, size);
	}

	@GetMapping(path = "/customer/{customerId}")

	List<OrderDto> getOrdersByCustomer(@PathVariable("customerId") int customerId) {
		return _orderSer.getOrdersByCustomer(customerId);
	}

	@PostMapping
	ResponseData saveOrder(@RequestBody(required = true) OrderDto order) {
		return _orderSer.saveOrder(order);
	}

	@PutMapping(path = "/{id}")
	ResponseData updateOrder(@PathVariable("id") int id, @RequestBody(required = true) OrderDto order) {
		return _orderSer.updateOrder(order, id);
	}

	@PutMapping(path = "/code/{code}")
	ResponseData updateOrder(@PathVariable("code") String code, @RequestBody(required = true) OrderDto order) {
		return _orderSer.updateOrderByCode(code, order);
	}

	@DeleteMapping(path = "/{id}")
	ResponseData deleteOrder(@PathVariable("id") int id) {
		return _orderSer.deleteOrder(id);
	}

	@DeleteMapping(path = "code/{code}")
	ResponseData deleteOrderByCode(@PathVariable("code") String code) {

		return _orderSer.deleteOrderByCode(code);
	}

	@PostMapping(path = "/add/{code}")
	ResponseData addProductToOrder(@PathVariable("code") String code,
			@RequestBody(required = true) OrderDetailDto orderData) {
		return _orderSer.addOrderDetail(orderData, code);
	}

	@PostMapping(path = "/add-many/{code}")
	ResponseData addProductsToOrder(@PathVariable("code") String code,

			@RequestBody(required = true) List<OrderDetailDto> orderData) {
		return _orderSer.addOrderDetails(orderData, code);
	}

	@PostMapping(path = "/cancel/{code}")
	ResponseData cancelOrder(@PathVariable("code") String code) {
		return _orderSer.cancelOrder(code);
	}

}
