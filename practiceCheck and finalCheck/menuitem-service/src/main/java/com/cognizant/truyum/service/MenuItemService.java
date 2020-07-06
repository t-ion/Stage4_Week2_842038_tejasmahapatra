package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired 
	private MenuItemDaoCollectionImpl menuItemDaoImpl;
	
	public List<MenuItem> getMenuItemListAdmin()
	{
		LOGGER.info("START MenuItemService getMenuItemListAdmin");
		List<MenuItem> listOfMenuItem = menuItemDaoImpl.getMenuItemListAdmin();
		
		LOGGER.debug("List:", listOfMenuItem);
		LOGGER.info("END MenuItemService getMenuItemListAdmin");
		return listOfMenuItem;
	}
	public List<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("START MenuItemService getMenuItemListCustomer");
		List<MenuItem> listOfMenuItem = menuItemDaoImpl.getMenuItemListCustomer();
		
		LOGGER.debug("List:", listOfMenuItem);
		LOGGER.info("END MenuItemService getMenuItemListCustomer");
		return listOfMenuItem;
	}
	
	public MenuItem getMenuItem(int id)
	{
		LOGGER.info("START MenuItemService getMenuItem");
		MenuItem menuItem = menuItemDaoImpl.getMenuItem(id);
		
		LOGGER.debug("MenuItem: {}",menuItem);		
		LOGGER.info("END MenuItemService getMenuItem");
		return menuItem;
	}
	
	public void modifyMenuItem(MenuItem menuItem)
	{
		LOGGER.info("START MenuItemService modifyMenuItem");
		
		menuItemDaoImpl.modifyMenuItem(menuItem);
		
		LOGGER.info("END MenuItemService modifyMenuItem");
		return;
	}
}
