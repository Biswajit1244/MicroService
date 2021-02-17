package com.biss.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biss.model.Product;
import com.biss.repo.ProductRepository;
import com.biss.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	public Integer saveProduct(Product p) {
		return repo.save(p).getProdId();
	}

	@Override
	public void updateProduct(Product p) {
		repo.save(p);
	}

	@Override
	public Optional<Product> getOneProduct(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void deleteOneProd(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return repo.findAll().stream().
				sorted((p1,p2)->
					p1.getProdPrice().compareTo(p2.getProdPrice()))
					.collect(Collectors.toList());
	}
	@Override
	public Boolean isExit(Integer id) {
		return repo.existsById(id);
	}

}
