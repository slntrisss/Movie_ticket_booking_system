package org.billboard.controller.home;

import org.billboard.dto.home.MoviePoster;
import org.billboard.model.Cinema;
import org.billboard.service.dao.CinemaService;
import org.billboard.service.dao.MovieService;
import org.billboard.service.dto.MoviePosterService;
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
    private final MoviePosterService posterService;

    public HomeController(CinemaService cinemaService,
                          MovieService movieService,
                          MoviePosterService posterService) {
        this.cinemaService = cinemaService;
        this.movieService = movieService;
        this.posterService = posterService;
    }

    @GetMapping("/movie-list")
    public ResponseEntity<List<MoviePoster>> getMoviePosters(){
        List<MoviePoster> moviePosters = posterService.getMoviePosters();
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
        List<MoviePoster> moviePosters = posterService.getMoviesToBeSoonReleased();
        return new ResponseEntity<>(moviePosters, HttpStatus.OK);
    }

    @GetMapping("/forKids")
    public ResponseEntity<List<MoviePoster>> getKidsMovies(){
        List<MoviePoster> moviePosters = posterService.getKidsMovies();
        return new ResponseEntity<>(moviePosters, HttpStatus.OK);
    }
}
