package com.capg.greatoutdoor.wishlistmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.wishlistmanagement.model.WishListDTO;

public interface IWishListRepository extends JpaRepository<WishListDTO,String> {

}
