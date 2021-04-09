package com.cesar_dev.rest_api.persistence.entity.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cesar_dev.rest_api.persistence.entity.Product;
import com.cesar_dev.rest_api.persistence.entity.dto.ProductDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mapping(target = "quantity", ignore = true)
	ProductDto toProductDto(Product product);

	List<ProductDto> toProductDtoAray(List<Product> product);

	List<Product> toProductAray(List<ProductDto> product);

	@Mapping(target = "orderDetail", ignore = true)
	@InheritInverseConfiguration
	Product toProduct(ProductDto productDto);

}
