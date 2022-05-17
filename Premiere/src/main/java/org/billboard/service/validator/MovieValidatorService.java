package org.billboard.service.validator;

import org.billboard.error.exception.InvalidMovieException;
import org.billboard.model.Movie;
import org.billboard.repository.dao.MovieDao;
import org.billboard.service.dao.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieValidatorService {
    private final MovieDao<Movie> movieRepo;

    @Autowired
    public MovieValidatorService(MovieDao<Movie> movieRepo) {
        this.movieRepo = movieRepo;
    }

    public boolean isValid(Movie movie) throws InvalidMovieException {
        if(movieRepo.exists(movie))
            throw new InvalidMovieException("Given movie already exists");
        return true;
    }
}
