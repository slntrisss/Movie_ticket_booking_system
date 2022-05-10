package org.billboard.service;

import org.billboard.model.Genre;
import org.billboard.model.MovieGenre;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreService {
    private final CrudRepository<MovieGenre> movieGenreRepo;
    private final GenreDao genreDao;

    @Autowired
    public MovieGenreService(CrudRepository<MovieGenre> movieGenreRepo, GenreDao genreDao) {
        this.movieGenreRepo = movieGenreRepo;
        this.genreDao = genreDao;
    }

    public List<Genre> getGenres(int movieId){
        return genreDao.getGenreList(movieId);
    }
}
