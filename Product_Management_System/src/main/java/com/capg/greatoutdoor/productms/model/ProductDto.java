package com.capg.greatoutdoor.productms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductDto {
	@Id
	private String productId;
	private double price;
	private String colour;
	private String dimension;
	private String specification;
	private String manufacture;
	private int quantity;
	private String productCategory;
	private String productName;
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(String productId, double price, String colour, String dimension, String specification,
			String manufacture, int quantity, String productCategory, String productName) {
		super();
		this.productId = productId;
		this.price = price;
		this.colour = colour;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacture = manufacture;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", price=" + price + ", colour=" + colour + ", dimension="
				+ dimension + ", specification=" + specification + ", manufacture=" + manufacture + ", quantity="
				+ quantity + ", productCategory=" + productCategory + ", productName=" + productName + "]";
	}
	
}
