package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {

	public void addFavoritesMovie(int userId, int movieId);
	public List<Movie> getAllFavoritesMovies(int userId) throws FavoritesEmptyException;
	public void removeFavoritesMovie(int userId, int movieId);
}
