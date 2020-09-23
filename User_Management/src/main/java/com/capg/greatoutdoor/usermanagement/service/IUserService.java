package com.capg.greatoutdoor.usermanagement.service;

import java.util.List;

import com.capg.greatoutdoor.usermanagement.model.User;

public interface IUserService {

	User add(User user);
	List<User> getAllUsers();
	void setTheWishList(String userId, String productId);
	void deleteFromTheWishList(String userId, String productId);

}
