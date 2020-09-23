package com.capg.greatoutdoor.wishlistmanagement.service;

import java.util.List;

import com.capg.greatoutdoor.wishlistmanagement.model.ProductDto;
import com.capg.greatoutdoor.wishlistmanagement.model.WishListDTO;

public interface IWishListService {

	WishListDTO addToWishList(WishListDTO wishListObject);

	

	boolean deleteFromWishList(String userId, String productId);



	List<ProductDto> viewProductsInWishList(String userId);



	boolean validateProductId(String productId);

}
