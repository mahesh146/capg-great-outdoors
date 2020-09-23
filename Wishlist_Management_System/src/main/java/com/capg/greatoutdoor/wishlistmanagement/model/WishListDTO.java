package com.capg.greatoutdoor.wishlistmanagement.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wish")
public class WishListDTO {
@Id
private String userId;
/*List of productId*/

@ElementCollection
private List<String> productIds;
public WishListDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public WishListDTO(String userId, List<String> productIds) {
	super();
	this.userId = userId;
	this.productIds = productIds;
}
/* Getters and Setters*/
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public List<String> getProductIds() {
	return productIds;
}
public void setProductIds(List<String> productIds) {
	this.productIds = productIds;
}
@Override
public String toString() {
	return "WishListDTO [userId=" + userId + ", productIds=" + productIds + "]";
}

}
