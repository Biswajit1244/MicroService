package com.biss.service;

import java.util.List;
import java.util.Optional;

import com.biss.model.Product;

public interface IProductService {
	Integer saveProduct(Product p);
	void updateProduct(Product p);
	Optional<Product> getOneProduct(Integer id);
	void deleteOneProd(Integer id);
	List<Product> getAllProduct();
	Boolean isExit(Integer id);
	}
