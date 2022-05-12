package org.billboard.repository.dao;

import org.billboard.model.Movie;

import java.io.Serializable;
import java.util.List;

public interface MovieDao<T extends Serializable> extends CrudRepository<T> {
    List<Movie> getMovieToBeSoonReleased();
    List<Movie> getKidsMovies();
    List<Movie> getAllMoviesByCinemaId(int cinemaId);
}
