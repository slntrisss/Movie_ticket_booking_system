package org.billboard.repository.dao;

import org.billboard.model.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getMovieToBeSoonReleased();
    List<Movie> getKidsMovies();
}
