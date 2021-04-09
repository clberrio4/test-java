package com.cesar_dev.rest_api.persistence.entity.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.cesar_dev.rest_api.persistence.entity.Order;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderDto;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OrderDetailMappper.class, OrderStatusMapper.class})
public interface OrderMapper {
	OrderMapper INSTANCE =Mappers.getMapper(OrderMapper.class);
	
	OrderDto toOrderDto(Order order); 
	
	List<OrderDto> orderDtoArray(List<Order> orders);

	@InheritInverseConfiguration
	Order toOrder(OrderDto orderDto); 
	
	@Mapping(target = "orderDetails", ignore = true)
	@InheritInverseConfiguration
	List<Order> toOrder(List<OrderDto> orderDto);
	
	
	
}

