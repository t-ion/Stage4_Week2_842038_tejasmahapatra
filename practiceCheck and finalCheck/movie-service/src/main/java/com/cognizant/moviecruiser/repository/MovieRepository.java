package com.cognizant.moviecruiser.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface MovieRepository extends CrudRepository<Movie,String>{
	
	@Query("select u from Movie u")
    public List<Movie> getMovieListAdmin();

	@Query("select u from Movie u where active=true")
	public List<Movie> getMovieListCustomer();

	@Query("select u from Movie u where id=?1")
	public Optional<Movie> findById(int id) throws MovieNotFoundException;
	
}
