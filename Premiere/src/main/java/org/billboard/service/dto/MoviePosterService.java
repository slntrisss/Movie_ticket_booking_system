package org.billboard.service.dto;

import org.billboard.dto.home.MoviePoster;
import org.billboard.model.Genre;
import org.billboard.model.Movie;
import org.billboard.service.dao.DetailService;
import org.billboard.service.dao.MovieGenreService;
import org.billboard.service.dao.MovieService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class MoviePosterService {
    private final MovieService movieService;
    private final MovieGenreService genreService;
    private final DetailService detailService;

    public MoviePosterService(MovieService movieService,
                              MovieGenreService genreService,
                              DetailService detailService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.detailService = detailService;
    }

    public List<MoviePoster> getMoviePosters(){
        List<Movie> movies = movieService.getAllMovies();
        return getMoviePosters(movies);
    }

    public List<MoviePoster> getMoviesToBeSoonReleased(){
        List<Movie> movies = movieService.getMoviesToBeSoonReleased();
        return getMoviePosters(movies);
    }

    public List<MoviePoster> getKidsMovies(){
        List<Movie> movies = movieService.getKidsMovies();
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
