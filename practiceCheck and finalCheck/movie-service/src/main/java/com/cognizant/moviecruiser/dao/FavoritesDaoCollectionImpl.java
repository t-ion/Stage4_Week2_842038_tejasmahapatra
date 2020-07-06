package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.FavoriteRepository;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class FavoritesDaoCollectionImpl implements FavoritesDao {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private FavoriteRepository favoriteRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);

	@Transactional
	public void addFavoritesMovie(int userId, int movieId) {
		LOGGER.info("favorite addFavoritesMovie() START");
		Favorites fav=new Favorites(userId,movieId);
		favoriteRepository.save(fav);
		LOGGER.info("favorite addFavoritesMovie() END");
	}
	
	@Transactional
	public List<Movie> getAllFavoritesMovies(int userId) throws FavoritesEmptyException {
		LOGGER.info("MovieDaoCollectionImpl.getAllFavoritesMovies START");
		List<Integer> list=favoriteRepository.getAllFavoritesMovies(userId);
		List<Movie> movie=new ArrayList<Movie>();
		for (Integer i : list) {
			Movie movie1=movieRepository.findById(i).get();
			movie.add(movie1);
		}
		LOGGER.info("MovieDaoCollectionImpl getAllFavoritesMovies END");
		return movie;
	}
	
	@Transactional
	public void removeFavoritesMovie(int userId, int movieId) {
		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie START");
		favoriteRepository.removeFavoritesMovie(userId, movieId);
		LOGGER.info("MovieDaoCollectionImpl removeFavoritesMovie END");
	}
	
}
