package com.cesar_dev.rest_api.persistence.entity.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.cesar_dev.rest_api.persistence.entity.OrderStatus;
import com.cesar_dev.rest_api.persistence.entity.dto.OrderStatusDto;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {
	OrderStatusMapper INSTANCE =Mappers.getMapper(OrderStatusMapper.class);
	
	
	
	OrderStatusDto toOrderStatusDto(OrderStatus orderStatus); 
	
	List<OrderStatusDto> orderStatusDto(List<OrderStatus> ordersStatus);
	
	@Mapping(target = "order", ignore = true)
	@InheritInverseConfiguration
	OrderStatus toOrderStatus(OrderStatusDto orderDto); 
}


