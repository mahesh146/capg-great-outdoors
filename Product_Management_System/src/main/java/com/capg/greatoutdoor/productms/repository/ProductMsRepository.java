package com.capg.greatoutdoor.productms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.productms.model.ProductDto;

public interface ProductMsRepository extends JpaRepository<ProductDto, String> {
//public ProductDto findByProductName(String productName);
public List<ProductDto> findByProductName(String ProductName);
public ProductDto findByManufacture(String manufacture);
public boolean existsByProductName(String productName);
}
