package com.cesar_dev.rest_api.service.interfaz;

import java.util.List;

import com.cesar_dev.rest_api.persistence.entity.dto.ProductDto;

public interface IProductService {

	public boolean savedProduct(ProductDto product);

	public boolean updateProduct(ProductDto product);

	public boolean deleteProduct(String code);

	public List<ProductDto> getAllProducts();
}
