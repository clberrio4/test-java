package com.cesar_dev.rest_api.repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cesar_dev.rest_api.persistence.entity.Order;
import com.cesar_dev.rest_api.persistence.entity.OrderDetail;
import com.cesar_dev.rest_api.persistence.entity.OrderStatus;
import com.cesar_dev.rest_api.persistence.entity.Product;
import com.cesar_dev.rest_api.persistence.entity.compositeKey.OrderDetailPK;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDetailDto;
import com.cesar_dev.rest_api.persistence.entity.mapper.OrderDetailMappper;
import com.cesar_dev.rest_api.repository.crud.OrderCrudRepository;
import com.cesar_dev.rest_api.repository.crud.OrderDetailCrudRepository;
import com.cesar_dev.rest_api.repository.crud.ProductCrudRepository;

@Repository
public class OrderDetailRepository {

	@Autowired
	private OrderDetailCrudRepository _crudOrderDetail;

	@Autowired
	private OrderCrudRepository _ordRep;

	@Autowired
	private ProductCrudRepository _repProd;

	@Autowired
	private OrderDetailMappper _ordDetailmapper;

	@Autowired
	private ProductCrudRepository _prodRepo;

	@Transactional
	public String addProductToShop(OrderDetailDto ordDetail, String code) {

		return _ordRep.findOneByCode(code).map(item -> {

			OrderDetail ord = new OrderDetail();

			ord.setId(new OrderDetailPK(item.getId(), ordDetail.getProductId()));

			ord.setQuantity(ordDetail.getQuantity());

			Optional<Product> p = _prodRepo.findById(ordDetail.getProductId());
			if (p.isEmpty()) {
				return "no empty";
			}

			Product prod = p.get();

			prod.setStock(p.get().getStock() - ord.getQuantity());

			_prodRepo.save(prod);

			item.setUpdatedAt(LocalDateTime.now());
			item.setSubtotal(prod.getPrice() * ord.getQuantity());

			_crudOrderDetail.save(ord);
			if (item.getSubtotal() > 70000 && item.getSubtotal() < 100000) {
				item.setTotal(
						(item.getSubtotal() + item.getDeliveryPrice()) + (item.getSubtotal() * (item.getIva() / 100)));
				ord.setOrders(item);
				return "generated with iva and delivery cost";
			} else if (item.getSubtotal() > 100000) {
				item.setTotal(item.getSubtotal() + (item.getSubtotal() * (item.getIva() / 100)));
				item.setDeliveryPrice(0);
				ord.setOrders(item);
				return "generated Without Delivery cost";
			}
			return "Order generated";
		}).orElse("don't exists");

	}

	@Transactional
	public String addManyOrders(List<OrderDetailDto> orders, String code) {
		orders.stream().map(item -> {

			OrderDetail detailItem = _ordDetailmapper.toOrderDetail(item);
			detailItem.setId(new OrderDetailPK(item.getOrderId(), item.getProductId()));

			Order ord = new Order();
			Product prod = _repProd.findById(item.getProductId()).get();

			ord.setSubtotal(item.getQuantity() + prod.getPrice());
			ord.setTotal(ord.getTotal() + ord.getSubtotal());
			_ordRep.save(ord);
			_crudOrderDetail.save(detailItem);
			return item;

		});
		return "ordersSaved";
	}

	@Transactional
	public String cancelOrder(String code) {

		return _ordRep.findOneByCode(code).map(item -> {

			Optional<List<OrderDetail>> orderDet = _crudOrderDetail.findDistinctByIdOrderId(item.getId());

			if (orderDet.isEmpty() || orderDet.isEmpty()) {
				return "does'nt exists";
			}

			long time = ChronoUnit.HOURS.between(item.getCreatedAt(), LocalDateTime.now());

			List<OrderDetail> ord = orderDet.get();

			if (time <= 12) {
				ord.forEach((x) -> {
					Product prd = _prodRepo.findById(x.getId().getProductId()).get();

					prd.setUpdatedAt(LocalDateTime.now());
					prd.setStock(prd.getStock() + x.getQuantity());

					_prodRepo.save(prd);

					_crudOrderDetail.delete(x);
					_ordRep.delete(item);

				});
				return "deleted Successfully";
			}
			ord.forEach((x) -> {

				Product prd = _prodRepo.findById(x.getId().getProductId()).get();

				prd.setUpdatedAt(LocalDateTime.now());
				prd.setStock(prd.getStock() + x.getQuantity());
				OrderStatus orderStatus = new OrderStatus();
				orderStatus.setId(3);

				item.setStatus(orderStatus);
				item.setTotal(item.getTotal() * 0.1);
				x.setOrders(item);

				_prodRepo.save(prd);
				_ordRep.save(item);
				_crudOrderDetail.delete(x);

			});

			return "cancelled ";
		}).orElse("doesn't exists");
	}

}
