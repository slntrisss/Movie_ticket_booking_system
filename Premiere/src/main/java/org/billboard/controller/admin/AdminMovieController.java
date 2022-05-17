package org.billboard.controller.admin;

import org.billboard.dto.home.MoviePoster;
import org.billboard.dto.movie.MovieDetail;
import org.billboard.error.Error;
import org.billboard.error.exception.InvalidHallException;
import org.billboard.error.exception.InvalidMovieException;
import org.billboard.service.dto.MovieDetailService;
import org.billboard.service.dto.MoviePosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/movie")
public class AdminMovieController {
    private final MoviePosterService posterService;
    private final MovieDetailService movieDetailService;

    @Autowired
    public AdminMovieController(MoviePosterService posterService,
                                MovieDetailService movieDetailService) {
        this.posterService = posterService;
        this.movieDetailService = movieDetailService;
    }

    @PostMapping("/add")
    @ExceptionHandler(InvalidMovieException.class)
    public ResponseEntity<?> save(@RequestBody MovieDetail movieDetail){
        try {
            movieDetailService.save(movieDetail);
        } catch (InvalidMovieException e) {
            Error error = new Error(HttpStatus.NOT_MODIFIED, e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ExceptionHandler(InvalidHallException.class)
    public ResponseEntity<?> update(@RequestBody MovieDetail movieDetail){
        movieDetailService.update(movieDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<?> delete(@PathVariable("movieId") int movieId){
        movieDetailService.delete(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<MoviePoster>> getAll(){
        List<MoviePoster> posters = posterService.getAllMovies();
        return new ResponseEntity<>(posters, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<MovieDetail> getMovieDetail(@PathVariable("id") int movieId){
        MovieDetail movieDetail = movieDetailService.getMovieDetail(movieId);
        return new ResponseEntity<>(movieDetail, HttpStatus.OK);
    }
}
