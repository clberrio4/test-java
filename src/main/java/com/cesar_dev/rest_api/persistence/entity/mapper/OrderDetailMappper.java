package com.cesar_dev.rest_api.persistence.entity.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.cesar_dev.rest_api.persistence.entity.OrderDetail;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDetailDto;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, OrderStatusMapper.class, OrderMapper.class })
public interface OrderDetailMappper {
	OrderDetailMappper INSTANCE = Mappers.getMapper(OrderDetailMappper.class);

	@Mapping(target = "orderId", ignore = true)
	@Mapping(target = "productId", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	@Mapping(target = "order", ignore = true)
	@Mapping(target = "products", ignore = true)
	OrderDetailDto toOrderDetailDto(OrderDetail orderDetail);

	List<OrderDetailDto> toOrderDetailDto(List<OrderDetail> orderDetail);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "orders", ignore = true)
	@InheritInverseConfiguration
	OrderDetail toOrderDetail(OrderDetailDto detail);

	List<OrderDetail> toOrderDetails(List<OrderDetailDto> detail);

}
