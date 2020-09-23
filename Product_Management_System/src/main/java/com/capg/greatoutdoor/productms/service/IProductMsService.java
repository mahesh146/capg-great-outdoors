package com.capg.greatoutdoor.productms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.greatoutdoor.productms.model.ProductDto;
import com.capg.greatoutdoor.productms.repository.ProductMsRepository;

public interface IProductMsService {
	public List<ProductDto> getAllProducts();
	public boolean addProduct(ProductDto product);
	public boolean editProduct(ProductDto product);
	public boolean deleteProduct(String productId);
	public List<ProductDto> searchProduct(String productDetail);
	public ProductDto getProduct(String productId);
}
