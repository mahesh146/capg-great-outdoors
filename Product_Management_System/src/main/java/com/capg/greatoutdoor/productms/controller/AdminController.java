package com.capg.greatoutdoor.productms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.productms.model.ProductDto;
import com.capg.greatoutdoor.productms.service.IProductMsService;
@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
private IProductMsService productService;

public List<ProductDto> searchProduct(@PathVariable String productDetail)
{
	return productService.searchProduct(productDetail);
}
}
