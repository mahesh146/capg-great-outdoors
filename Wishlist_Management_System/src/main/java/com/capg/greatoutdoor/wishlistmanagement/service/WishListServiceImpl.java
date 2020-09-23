package com.capg.greatoutdoor.wishlistmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.wishlistmanagement.exceptions.ProductAlreadyExistsException;
import com.capg.greatoutdoor.wishlistmanagement.exceptions.ProductException;
import com.capg.greatoutdoor.wishlistmanagement.exceptions.UserDoesnotExistsException;
import com.capg.greatoutdoor.wishlistmanagement.model.ProductDto;
import com.capg.greatoutdoor.wishlistmanagement.model.WishListDTO;
import com.capg.greatoutdoor.wishlistmanagement.repository.IWishListRepository;

@Service
public class WishListServiceImpl implements IWishListService {
	@Autowired
	private IWishListRepository wishListRepository;
	@Autowired
	private RestTemplate restTemplate;

	/****************************************************************************************************
	 ** FunctionName:addToWishList() Description:adding the product to wishlist of an
	 * existing user
	 **
	 ****************************************************************************************************/

	@Override
	public WishListDTO addToWishList(WishListDTO wishListObject) {
		// TODO Auto-generated method stub
		if (wishListRepository.existsById(wishListObject.getUserId())) {

			WishListDTO existingWishList = wishListRepository.getOne(wishListObject.getUserId());
			for (String productId : wishListObject.getProductIds()) {
				if(existingWishList.getProductIds().contains(productId)) {
					throw new ProductAlreadyExistsException("product with productId "+productId+" already exists");
				}
				existingWishList.getProductIds().add(productId);
				restTemplate.put(
						"http://localhost:8400/userdata/setlist/" + wishListObject.getUserId() + "/" + productId,
						ProductDto.class);
			}

			return wishListRepository.save(existingWishList);

		} else {
			return wishListRepository.save(wishListObject);
		}

	}

	/****************************************************************************************************
	 ** FunctionName:deleteFromWishList() Description:deleting the product from
	 * wishlist of an existing user
	 **
	 ****************************************************************************************************/
	@Override
	public boolean deleteFromWishList(String userId, String productId) {
		// TODO Auto-generated method stub
		if (wishListRepository.existsById(userId)) {
			WishListDTO existingWishList = wishListRepository.getOne(userId);
			existingWishList.getProductIds().remove(productId);
			restTemplate.delete("http://localhost:8400/userdata/deletelist/" + userId + "/" + productId);
			wishListRepository.save(existingWishList);
			return true;
		}
		throw new UserDoesnotExistsException("User with userId " + userId + " doesnot exist");
	}

	/****************************************************************************************************
	 ** FunctionName:viewProductsInWishList Description:Find all the products in the
	 * wishlist added by an existing user
	 **
	 ****************************************************************************************************/

	@Override
	public List<ProductDto> viewProductsInWishList(String userId) {
		// TODO Auto-generated method stub
		if (wishListRepository.existsById(userId)) {
			WishListDTO wishListObject = wishListRepository.getOne(userId);
			List<String> products = wishListObject.getProductIds();
			List<ProductDto> productList = new ArrayList<>();
			for (String string : products) {
				ProductDto product = restTemplate
						.getForObject("http://localhost:8300/productmaster/get/productId/" + string, ProductDto.class);
				productList.add(product);
			}

			return productList;

		} else
			throw new UserDoesnotExistsException("User with userId " + userId + " doesnot exist");

	}
	
	@Override
	public boolean validateProductId(String productId) {
		Pattern validate= Pattern.compile("^[a-zA-Z0-9]*$");
		
		if (!validate.matcher(productId).find()) {
			throw new ProductException("Product id must be a string");
		}
		return true;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}