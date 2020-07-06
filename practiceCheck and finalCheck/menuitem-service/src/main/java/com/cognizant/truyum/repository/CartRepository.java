package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {

	@Query("select f.c_id from Cart f where us_id=?1")
	public List<Integer> getAllCartItems(int userId) throws CartEmptyException;

	@Modifying
	@Query("delete from Cart f where f.us_id=?1 and f.c_id=?2")
	public void removeCartItem(int userId, int menuItemId);
}
