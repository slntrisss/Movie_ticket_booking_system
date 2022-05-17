package org.billboard.service.dao;

import org.billboard.error.exception.InvalidMovieException;
import org.billboard.model.*;
import org.billboard.repository.dao.MovieDao;
import org.billboard.service.validator.MovieValidatorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    private final MovieDao<Movie> movieRepo;
    private final MovieValidatorService validatorService;

    public MovieService(MovieDao<Movie> movieRepo,
                        MovieValidatorService validatorService) {
        this.movieRepo = movieRepo;
        this.validatorService = validatorService;
    }

    public List<Movie> getAllMovies(){
        return movieRepo.getAll();
    }

    public List<Movie> getAllMoviesByCinemaId(int cinemaId){
        return movieRepo.getAllMoviesByCinemaId(cinemaId);
    }

    public Movie findOneById(int movieId){
        return movieRepo.findOneById(movieId);
    }

    public List<Movie> getMoviesToBeSoonReleased(){
        return movieRepo.getMovieToBeSoonReleased();
    }

    public List<Movie> getKidsMovies(){
        return movieRepo.getKidsMovies();
    }

    public boolean exists(Movie movie){
        return movieRepo.exists(movie);
    }

    public void save(Movie movie) throws InvalidMovieException {
        boolean isValid = validatorService.isValid(movie);
        if(isValid)
            movieRepo.save(movie);
    }

    public Integer getLastId(){
        return movieRepo.getLastId();
    }

    public List<Movie> getAvailableMovies(){
        return movieRepo.getAvailableCinemas();
    }

    public void update(Movie movie) throws InvalidMovieException {
        boolean valid = validatorService.isValid(movie);
        if(valid)
            movieRepo.update(movie);
    }
}
