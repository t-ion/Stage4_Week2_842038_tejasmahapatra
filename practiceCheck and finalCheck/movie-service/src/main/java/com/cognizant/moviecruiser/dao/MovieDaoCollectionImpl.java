package com.cognizant.moviecruiser.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecruiser.MoviecruiserApplication;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Repository
public class MovieDaoCollectionImpl implements MovieDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);
	
	@Autowired
	MovieRepository movieRepository;
	
	@Transactional
	public List<Movie> getMovieListAdmin() {
		LOGGER.info("MovieDaoCollectionImpl.getMovieListAdmin() START");
		List<Movie> list=movieRepository.getMovieListAdmin();
		LOGGER.info("MovieDaoCollectionImpl.getMovieListAdmin() END");
		return list;
	}
	@Transactional
	public List<Movie> getMovieListCustomer() {
		LOGGER.info("MovieDaoCollectionImpl.getMovieListCustomer() START");
		List<Movie> list=movieRepository.getMovieListCustomer();
		LOGGER.info("MovieDaoCollectionImpl.getMovieListCustomer() END");
		return list;
	}
	
	@Transactional
	public Movie findById(int movieId) {
		LOGGER.info("MovieDaoCollectionImpl Movie findById(int id) START");
		
		Optional<Movie> res=movieRepository.findById(movieId);
		Movie movie=res.get();
		
		LOGGER.info("MovieDaoCollectionImpl Movie findById(int id) END");
		return movie;
	}

	@Transactional
	public void modifyMovie(Movie movie){
		LOGGER.info("MovieDaoCollectionImpl modifyMovie(Movie movie) START");
		Optional<Movie> res=movieRepository.findById(movie.getId());
		Movie movie1=res.get();
		movie1.setTitle(movie.getTitle());
		movie1.setActive(movie.isActive());
		movie1.setBoxOffice(movie.getBoxOffice());
		movie1.setDateOfLaunch(movie.getDateOfLaunch());
		movie1.setGenre(movie.getGenre());
		movie1.setHasTeaser(movie.isHasTeaser());
		
		LOGGER.debug("MovieUpdate: {}", movie1);
		movieRepository.save(movie1);
		LOGGER.info("MovieDaoCollectionImpl modifyMovie(Movie movie) END");

	}

}
