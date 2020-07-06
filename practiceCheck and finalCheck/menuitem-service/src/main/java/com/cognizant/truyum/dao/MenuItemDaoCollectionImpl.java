package com.cognizant.truyum.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;;

@Service
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.debug("Transactional getadminlist start");
		List<MenuItem> menu=menuItemRepository.getMenuItemListAdmin();
		return menu;
	}
	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.debug("Transactional getCustomerlist start");
		List<MenuItem> menu=menuItemRepository.getMenuItemListCustomer();
			return menu;
	}

	@Transactional
	public MenuItem getMenuItem(int menuItemId) {
		LOGGER.debug("Transactional getmenuitem by id start");
		MenuItem menuitem1=menuItemRepository.findById(menuItemId).orElseThrow(()->{throw new MenuItemNotFoundException();});
		return menuitem1;
	}


	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.debug("Transactional modify item start");
		MenuItem menuitem1=menuItemRepository.findById(menuItem.getId()).orElseThrow(()->{throw new MenuItemNotFoundException();});
//		MenuItem menuitem1=res.get();
		menuitem1.setActive(menuItem.isActive());
		menuitem1.setCategory(menuItem.getCategory());
		menuitem1.setDateOfLaunch(menuItem.getDateOfLaunch());
		menuitem1.setFreeDelivery(menuItem.isFreeDelivery());
		menuitem1.setName(menuItem.getName());
		menuitem1.setPrice(menuItem.getPrice());
		
		menuItemRepository.save(menuitem1);

	}
}
