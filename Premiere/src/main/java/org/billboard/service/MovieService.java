package org.billboard.service;

import org.billboard.dto.home.MoviePoster;
import org.billboard.model.Genre;
import org.billboard.model.Movie;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.MovieDao;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class MovieService {
    private final CrudRepository<Movie> movieRepo;
    private final DetailService detailService;
    private final MovieGenreService genreService;
    private final MovieDao movieDao;

    public MovieService(CrudRepository<Movie> movieRepo,
                        DetailService detailService,
                        MovieGenreService genreService,
                        MovieDao movieDao) {
        this.movieRepo = movieRepo;
        this.detailService = detailService;
        this.genreService = genreService;
        this.movieDao = movieDao;
    }

    public List<Movie> getAllMovies(){
        return movieRepo.getAll();
    }

    public Movie getMovieById(int movieId){
        return movieRepo.findOneById(movieId);
    }

    public List<MoviePoster> getMoviePosters(){
        List<Movie> movies = getAllMovies();
        return getMoviePosters(movies);
    }

    public List<MoviePoster> getMoviesToBeSoonReleased(){
        List<Movie> movies = movieDao.getMovieToBeSoonReleased();
        return getMoviePosters(movies);
    }

    public List<MoviePoster> getKidsMovies(){
        List<Movie> movies = movieDao.getKidsMovies();
        return getMoviePosters(movies);
    }

    private List<MoviePoster> getMoviePosters(List<Movie> movies){
        List<MoviePoster> moviePosters = new LinkedList<>();
        for(Movie movie: movies){
            MoviePoster moviePoster = new MoviePoster();
            List<Genre> genres = genreService.getGenres(movie.getMovieId());
            Date releasedDate = detailService.getReleasedDate(movie.getMovieId());
            String formattedDate = formatDate(releasedDate);

            moviePoster.setMovie(movie);
            moviePoster.setGenres(genres);
            moviePoster.setReleaseDate(releasedDate);
            moviePoster.setFormattedDate(formattedDate);
            moviePosters.add(moviePoster);
        }
        return moviePosters;
    }


    private String formatDate(Date releasedDate){
        String pattern = "dd MMMM, yyyy";
        SimpleDateFormat newFormat = new SimpleDateFormat(pattern, Locale.US);
        return newFormat.format(releasedDate);
    }
}
