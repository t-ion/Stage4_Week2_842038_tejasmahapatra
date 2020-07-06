package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.CartRepository;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class CartDaoCollectionImpl implements CartDao{

	@Autowired
	CartRepository cartRepository;
	@Autowired
	MenuItemRepository menuItemRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	@Transactional
	public void addCartItem(int userId, int menuItemId) {
		LOGGER.info("START CartDaoImpl addCartItem");
		Cart cart=new Cart(userId, menuItemId);
		cartRepository.save(cart);
		LOGGER.info("END CartDaoImpl addCartItem");
	}

	@Transactional
	public List<MenuItem> getAllCartItems(int userId) throws CartEmptyException {
		LOGGER.info("START CartDaoImpl getAllCartItems");
		List<MenuItem> cart;
		List<Integer> menuItemList=cartRepository.getAllCartItems(userId);
		if (menuItemList.isEmpty()) {
			throw new CartEmptyException();
		} else {
		cart=new ArrayList<MenuItem>();
		for (Integer i : menuItemList) {
			MenuItem item =menuItemRepository.findById(i).get();
			cart.add(item);
		}
		}
		LOGGER.info("END CartDaoImpl getAllCartItems");
		return cart;
	}

	@Transactional
	public void removeCartItem(int userId, int menuItemId) {
		LOGGER.info("START CartDaoImpl removeCartItem");
		cartRepository.removeCartItem(userId, menuItemId);
      LOGGER.info("END CartDaoImpl removeCartItem");
	}

}
