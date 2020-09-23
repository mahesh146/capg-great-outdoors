package com.capg.greatoutdoor.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.usermanagement.model.User;
import com.capg.greatoutdoor.usermanagement.service.IUserService;

@RestController
@RequestMapping("/userdata")
public class UserManagementController {
@Autowired
private IUserService service;
@PostMapping("/add")
public User add(@RequestBody User user)
{
	return service.add(user);
}

@GetMapping("/getallusers")
public List<User> getAllUsers()
{
return service.getAllUsers();	
}
@PutMapping("/setlist/{userId}/{productId}")
public void setTheWishList(@PathVariable String userId,@PathVariable String productId)
{
 service.setTheWishList(userId,productId);
}
@DeleteMapping("deletelist/{userId}/{productId}")
public void deleteFromTheWishList(@PathVariable String userId,@PathVariable String productId)
{
service.deleteFromTheWishList(userId,productId);
}
}
