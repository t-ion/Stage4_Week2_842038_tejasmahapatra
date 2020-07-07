package com.cognizant.truyum.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	private CartService cartService;

	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable @Valid int userId, @PathVariable @Valid int menuItemId) {

		LOGGER.info("START CartController addCartItem ");

		cartService.addCartItem(userId, menuItemId);

		LOGGER.info("END CartController addCartItem ");
	}

	@GetMapping("/{userId}")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable @Valid int userId) {
		LOGGER.info("START CartController getAllCartItem ");
		return (ArrayList<MenuItem>) cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void removeCartItem(@PathVariable @Valid int userId,@PathVariable @Valid int menuItemId) {
		
		LOGGER.info("START CartController removeCartItem ");

		cartService.removeCartItem(userId, menuItemId);

		LOGGER.info("END CartController removeCartItem ");
	}
}
