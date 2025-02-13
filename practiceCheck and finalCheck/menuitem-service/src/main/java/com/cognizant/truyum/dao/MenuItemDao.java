package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin();
	public List<MenuItem> getMenuItemListCustomer();
	
	public MenuItem getMenuItem(int id) throws MenuItemNotFoundException ;
	
	public void modifyMenuItem(MenuItem menuItem);
}