package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;

public interface FavoriteRepository extends CrudRepository<Favorites,String> {

	@Query("select f.mv_id from Favorites f where us_id=?1")
	public List<Integer> getAllFavoritesMovies(int userId) throws FavoritesEmptyException;
	
	@Modifying
	@Query("delete from Favorites f where f.us_id=?1 and f.mv_id=?2")
    public void removeFavoritesMovie(int userId, int movieId);
}
