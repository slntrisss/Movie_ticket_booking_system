package org.billboard.service.dto;

import org.billboard.dto.movie.MovieDetail;
import org.billboard.error.exception.InvalidMovieException;
import org.billboard.model.Detail;
import org.billboard.model.Genre;
import org.billboard.model.Movie;
import org.billboard.model.RoleDetail;
import org.billboard.service.dao.DetailService;
import org.billboard.service.dao.MovieGenreService;
import org.billboard.service.dao.MovieService;
import org.billboard.service.dao.RoleDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDetailService {
    private final MovieService movieService;
    private final DetailService detailService;
    private final RoleDetailService roleDetailService;
    private final MovieGenreService genreService;

    public MovieDetailService(MovieService movieService,
                              DetailService detailService,
                              RoleDetailService roleDetailService,
                              MovieGenreService genreService) {
        this.movieService = movieService;
        this.detailService = detailService;
        this.roleDetailService = roleDetailService;
        this.genreService = genreService;
    }

    public MovieDetail getMovieDetail(int movieId){
        MovieDetail movieDetail = new MovieDetail();

        Movie movie = movieService.findOneById(movieId);
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

    public void save(MovieDetail movieDetail) throws InvalidMovieException {
        Movie movie = movieDetail.getMovie();
        movieService.save(movie);
        int movieId = movieService.getLastId();

        Detail detail = movieDetail.getDetail();
        detailService.save(detail, movieId);

        List<RoleDetail> roleDetails = movieDetail.getRoleDetails();
        roleDetailService.save(roleDetails, detailService.getLastId());

        List<Genre> genres = movieDetail.getGenres();
        genreService.save(genres, movieId);
    }

    public void update(MovieDetail movieDetail) throws InvalidMovieException{
        Movie movie = movieDetail.getMovie();
        movieService.update(movie);

        Detail detail = movieDetail.getDetail();
        detailService.update(detail);

        roleDetailService.delete(detail.getDetailId());
        genreService.delete(movie.getMovieId());

        List<RoleDetail> roleDetails= movieDetail.getRoleDetails();
        roleDetailService.save(roleDetails, detail.getDetailId());

        List<Genre> genres = movieDetail.getGenres();
        genreService.save(genres, movie.getMovieId());
    }
}
