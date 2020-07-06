package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(int userId, int menuItemId);

	public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException;

	public void removeCartItem(int userId, int menuItemId);
}
