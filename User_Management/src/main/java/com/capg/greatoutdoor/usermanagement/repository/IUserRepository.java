package com.capg.greatoutdoor.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.usermanagement.model.User;

public interface IUserRepository extends JpaRepository<User, String> {
	public User getUserByUserName(String userName);
	public User getUserByUserNumber(long userNumber);
	public User getUserByUserMail(String userMail);
}
