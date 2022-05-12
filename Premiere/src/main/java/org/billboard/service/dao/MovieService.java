package org.billboard.service.dao;

import org.billboard.dto.home.MoviePoster;
import org.billboard.dto.movie.MovieDetail;
import org.billboard.model.*;
import org.billboard.repository.dao.MovieDao;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
public class MovieService {
    private final DetailService detailService;
    private final MovieGenreService genreService;
    private final MovieDao<Movie> movieRepo;
    private final RoleDetailService roleDetailService;

    public MovieService(DetailService detailService,
                        MovieGenreService genreService,
                        MovieDao<Movie> movieRepo,
                        RoleDetailService roleDetailService) {
        this.detailService = detailService;
        this.genreService = genreService;
        this.movieRepo = movieRepo;
        this.roleDetailService = roleDetailService;
    }

    public List<Movie> getAllMovies(){
        return movieRepo.getAll();
    }

    public List<Movie> getAllMoviesByCinemaId(int cinemaId){
        return movieRepo.getAllMoviesByCinemaId(cinemaId);
    }

    public MovieDetail getMovieDetail(int movieId){
        MovieDetail movieDetail = new MovieDetail();

        Movie movie = movieRepo.findOneById(movieId);
        Detail detail = detailService.getDetailsByMovieId(movieId);
        List<RoleDetail> roleDetails = roleDetailService.
                getRoleDetailByDetailId(detail.getDetailId());
        List<Genre> genres = genreService.getGenres(movieId);

        movieDetail.setMovie(movie);
        movieDetail.setDetail(detail);
        movieDetail.setGenres(genres);
        movieDetail.setRoleDetails(roleDetails);
        return movieDetail;
    }

    public List<MoviePoster> getMoviePosters(){
        List<Movie> movies = getAllMovies();
        return getMoviePosters(movies);
    }

    public List<MoviePoster> getMoviesToBeSoonReleased(){
        List<Movie> movies = movieRepo.getMovieToBeSoonReleased();
        return getMoviePosters(movies);
    }

    public List<MoviePoster> getKidsMovies(){
        List<Movie> movies = movieRepo.getKidsMovies();
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
