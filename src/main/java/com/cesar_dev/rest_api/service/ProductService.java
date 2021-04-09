package com.cesar_dev.rest_api.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesar_dev.rest_api.persistence.entity.dto.ProductDto;
import com.cesar_dev.rest_api.persistence.entity.mapper.ProductMapper;
import com.cesar_dev.rest_api.repository.crud.ProductCrudRepository;
import com.cesar_dev.rest_api.service.interfaz.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductCrudRepository _prodRepo;

	@Autowired
	private ProductMapper _prodMapper;

	@Override
	public boolean savedProduct(ProductDto product) {
		if (_prodRepo.findByCode(product.getCode()).isEmpty()) {

			product.setCreatedAt(LocalDateTime.now());
			product.setUpdatedAt(LocalDateTime.now());
			if (!_prodRepo.save(_prodMapper.toProduct(product)).getCode().equals(""))
				return true;
		}
		return false;
	}

	@Override
	public boolean updateProduct(ProductDto product) {
		product.setUpdatedAt(LocalDateTime.now());
		if (_prodRepo.save(_prodMapper.toProduct(product)).getCode().equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteProduct(String code) {
		return _prodRepo.findByCode(code).map(x -> {
			_prodRepo.delete(x);
			return true;
		}).orElse(false);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		return _prodMapper.toProductDtoAray(_prodRepo.findAll());
	}
}
