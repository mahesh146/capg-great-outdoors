package com.capg.greatoutdoor.wishlistmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.wishlistmanagement.model.ProductDto;
import com.capg.greatoutdoor.wishlistmanagement.model.WishListDTO;
import com.capg.greatoutdoor.wishlistmanagement.service.IWishListService;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
	
	@Autowired
	private IWishListService service;
	
	/*
	*---------------WISHLIST RESOURCES----------------------------------------------------------------------
	*
	*/
	
	
	/*
	 * ------------------------Adding the wishlist object-------------------------------
	 */
	
	@PostMapping("/add")
	public WishListDTO addToWishList(@RequestBody WishListDTO wishListObject)
	{
		return service.addToWishList(wishListObject);
	}
	/*
	 * ---------------------------deleting the product ID--------------------------
	 * 
	 */
	
	@DeleteMapping("/delete/{userId}/{productId}")
	public boolean deleteFromWishList(@PathVariable String userId,@PathVariable String productId)
	{
		return service.deleteFromWishList(userId,productId);
	}
	/*
	 * ----------------------------fetching the product Id------------------------------
	 * 
	 */
	@GetMapping("getwishlist/{userId}")
	public List<ProductDto> viewProductsInWishList(@PathVariable String userId)
	{
		return service.viewProductsInWishList(userId);
	}

	

}
