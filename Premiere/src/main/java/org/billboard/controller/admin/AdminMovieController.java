package org.billboard.controller.admin;

import org.billboard.dto.movie.MovieDetail;
import org.billboard.error.Error;
import org.billboard.error.exception.InvalidHallException;
import org.billboard.error.exception.InvalidMovieException;
import org.billboard.service.dao.MovieService;
import org.billboard.service.dto.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/movie")
public class AdminMovieController {
    private final MovieService movieService;
    private final MovieDetailService movieDetailService;

    @Autowired
    public AdminMovieController(MovieService movieService,
                                MovieDetailService movieDetailService) {
        this.movieService = movieService;
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
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
