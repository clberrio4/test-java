package com.cesar_dev.rest_api.persistence.entity.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.cesar_dev.rest_api.persistence.entity.Customer;
import com.cesar_dev.rest_api.persistence.entity.dto.CustomerDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
	CustomerMapper INSTANCE =Mappers.getMapper(CustomerMapper.class);
	
	CustomerDto toCustomerDto(Customer customer); 
	
	
	@InheritInverseConfiguration
	Customer toCustomer(CustomerDto customerDto); 
}
