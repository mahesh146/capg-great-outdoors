package com.capg.greatoutdoor.wishlistmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.greatoutdoor.wishlistmanagement.exceptions.ProductException;
import com.capg.greatoutdoor.wishlistmanagement.service.WishListServiceImpl;

@SpringBootTest
class WishlistManagementSystemApplicationTests {
	
	@Autowired
	WishListServiceImpl wishListService;
	
	@Test
	public void testValidateProductId(){
		assertEquals(true,wishListService.validateProductId("PRO17685"));
	}

	@Test
	public void testInvalidProductId(){
		 Exception exception = assertThrows(ProductException.class, () -> {
			wishListService.validateProductId("Product");
		    });
		 
		    String expectedMessage = "Invalid ProductId";
		    String actualMessage = exception.getMessage();
		    System.out.println(actualMessage);
		 
		    assertFalse(actualMessage.contains(expectedMessage));
	}

}
