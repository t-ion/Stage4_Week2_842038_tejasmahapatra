package com.cognizant.moviecruiser.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavoritesDaoCollectionImpl;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class FavoritesService {

	@Autowired
	private FavoritesDaoCollectionImpl favoritesDaoCollectionImpl;
	
	public List<Movie> getAllFavoritesMovies(@Valid int userId) {
		return favoritesDaoCollectionImpl.getAllFavoritesMovies(userId);
	}
	
	public void removeFavoritesMovie(int userId, int movieId) {
		
		favoritesDaoCollectionImpl.removeFavoritesMovie(userId, movieId);
	}
	
	public void addFavoritesMovie(int userId, int movieId) {
		favoritesDaoCollectionImpl.addFavoritesMovie(userId, movieId);
	}
}
