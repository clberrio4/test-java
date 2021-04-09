package com.cesar_dev.rest_api.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import com.cesar_dev.rest_api.persistence.entity.Customer;
import com.cesar_dev.rest_api.persistence.entity.Order;
import com.cesar_dev.rest_api.persistence.entity.OrderDetail;
import com.cesar_dev.rest_api.persistence.entity.Product;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDto;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderPaginated;
import com.cesar_dev.rest_api.persistence.entity.dto.ProductDto;
import com.cesar_dev.rest_api.persistence.entity.mapper.OrderMapper;
import com.cesar_dev.rest_api.persistence.entity.mapper.ProductMapper;
import com.cesar_dev.rest_api.repository.crud.CustomerCrudRepository;
import com.cesar_dev.rest_api.repository.crud.OrderCrudRepository;
import com.cesar_dev.rest_api.repository.crud.ProductCrudRepository;

@Repository
public class OrderRepository {

	@Autowired
	private OrderCrudRepository _orderCrud;

	@Autowired
	private CustomerCrudRepository _customerCrud;

	@Autowired
	private ProductCrudRepository _productCrud;

	@Autowired
	private OrderMapper _orderMapper;

	@Autowired
	private ProductMapper _prodMapper;

	public OrderPaginated findAll(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Order> orderPaginated = _orderCrud.findAll(pageRequest);
		OrderPaginated order = new OrderPaginated();

		if (orderPaginated.hasContent()) {
			List<OrderDto> orders = _orderMapper.orderDtoArray(orderPaginated.getContent());
			order.setOrders(orders);
			order.setHasNext(orderPaginated.hasNext());
			order.setTotalPages(orderPaginated.getTotalPages());
			order.setHasPrevious(orderPaginated.hasPrevious());
			order.setCurrentPage(page);
			return order;
		}
		return order;
	}

	public List<OrderDto> findByCustomerId(int customerId) {
		List<OrderDto> orders = _orderMapper.orderDtoArray(_orderCrud.findByCustomerId(customerId).get());
		return orders;
	}

	public Order findByOrderCode(String code) {
		return _orderCrud.findOneByCode(code).orElse(null);
	}

	public boolean saveOrder(Order order) {
		Order ord = findByOrderCode(order.getCode());
		if (ord != null) {
			return false;
		}
		Customer customer = _customerCrud.findById(order.getCustomer().getId()).get();
		if (customer != null) {
			order.setCustomer(customer);
			order.setCreatedAt(LocalDateTime.now());
			order.setUpdatedAt(LocalDateTime.now());
			_orderCrud.save(order);
			return true;
		}
		return false;
	}

	public boolean deleteOrder(int orderId) {
		Optional<Order> order = _orderCrud.findById(orderId);
		if (order.isPresent()) {
			_orderCrud.delete(order.get());
			return true;
		}
		return false;
	}

	public boolean deleteOrderByCode(String code) {
		Optional<Order> order = _orderCrud.findOneByCode(code);
		if (order.isPresent()) {
			Order ord = order.get();

			// System.out.println(Hours.hoursBetween(ord.getCreatedAt(), DateTime.now()));

			// _orderCrud.delete(order.get());
			return true;
		}
		return false;
	}

	public boolean updateOrder(Order order, int orderId) {
		Optional<Order> orderOpt = _orderCrud.findById(orderId);
		if (orderOpt.isPresent()) {
			order.setCreatedAt(orderOpt.get().getCreatedAt());
			order.setUpdatedAt(LocalDateTime.now());
			order.setId(orderId);
			_orderCrud.save(order);
			return true;
		}
		return false;
	}

	public boolean updateOrderByCode(Order order, String code) {
		Optional<Order> orderOpt = _orderCrud.findOneByCode(code);
		if (orderOpt.isPresent()) {
			order.setCreatedAt(orderOpt.get().getCreatedAt());
			order.setUpdatedAt(LocalDateTime.now());
			order.setId(orderOpt.get().getId());
			_orderCrud.save(order);
			return true;
		}
		return false;
	}

	public boolean addProductToOrder(String code, List<ProductDto> orders) {

		Optional<Order> orderOpt = _orderCrud.findOneByCode(code);
		if (orderOpt.isPresent()) {
			Order orderToAdd = orderOpt.get();

			Set<OrderDetail> ordersDetail = orderToAdd.getOrderDetails();

			Product prod = _prodMapper.toProduct(orders.get(0));

			OrderDetail ord = new OrderDetail();

			ord.setProducts(prod);
			ordersDetail.add(ord);
			prod.setOrderDetail(null);

			orderToAdd.setUpdatedAt(LocalDateTime.now());

			orderToAdd.setOrderDetails(ordersDetail);

			_orderCrud.save(orderToAdd);
			return true;
		}
		return false;
	}

}
