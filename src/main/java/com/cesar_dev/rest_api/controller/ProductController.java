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
import org.springframework.web.bind.annotation.RestController;

import com.cesar_dev.rest_api.persistence.entity.dto.ProductDto;
import com.cesar_dev.rest_api.persistence.entity.dto.ResponseData;
import com.cesar_dev.rest_api.service.interfaz.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService _prodServ;

	@GetMapping()
	public List<ProductDto> getProducts() {
		return _prodServ.getAllProducts();
	}

	@PostMapping()
	public ResponseData saveProduct(@RequestBody(required = true) ProductDto prodDto) {
		boolean status = _prodServ.savedProduct(prodDto);
		return new ResponseData(status ? "product saved" : "can't save product", status);
	}

	@PutMapping(path = "/{id}")
	public ResponseData updateProduct(@PathVariable(name = "id") int productId,
			@RequestBody(required = true) ProductDto prodDto) {
		prodDto.setId(productId);
		boolean status = _prodServ.updateProduct(prodDto);
		return new ResponseData(status ? "product updated" : "can't be upated", status);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseData deleteUser(@PathVariable(name = "id") String codeProd) {
		boolean status = _prodServ.deleteProduct(codeProd);
		return new ResponseData(status ? "product deleted" : "can't be deleted", status);
	}

}
