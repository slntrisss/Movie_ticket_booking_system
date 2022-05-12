package org.billboard.controller.home;

import org.billboard.dto.home.MoviePoster;
import org.billboard.model.Cinema;
import org.billboard.service.dao.CinemaService;
import org.billboard.service.dao.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final CinemaService cinemaService;
    private final MovieService movieService;

    public HomeController(CinemaService cinemaService,
                          MovieService movieService) {
        this.cinemaService = cinemaService;
        this.movieService = movieService;
    }

    @GetMapping("/movie-list")
    public ResponseEntity<List<MoviePoster>> getMoviePosters(){
        List<MoviePoster> moviePosters = movieService.getMoviePosters();
        return new ResponseEntity<>(moviePosters, HttpStatus.OK);
    }

    @GetMapping("/cinema-list")
    public ResponseEntity<List<Cinema>> getCinemaPosters(@RequestParam(value = "limit", required = false)
                                                                     String limit){
        List<Cinema> cinemas = cinemaService.getCinemaPosters(limit);
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/soon")
    public ResponseEntity<List<MoviePoster>> getMoviesToBeSoonReleased(){
        List<MoviePoster> moviePosters = movieService.getMoviesToBeSoonReleased();
        return new ResponseEntity<>(moviePosters, HttpStatus.OK);
    }

    @GetMapping("/forKids")
    public ResponseEntity<List<MoviePoster>> getKidsMovies(){
        List<MoviePoster> moviePosters = movieService.getKidsMovies();
        return new ResponseEntity<>(moviePosters, HttpStatus.OK);
    }
}
