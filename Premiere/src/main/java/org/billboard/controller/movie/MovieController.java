package org.billboard.controller.movie;

import org.billboard.dto.movie.MovieDetail;
import org.billboard.dto.scheduleSort.CinemaMovieSchedule;
import org.billboard.service.dao.MovieService;
import org.billboard.service.dto.MovieDetailService;
import org.billboard.service.dto.ScheduleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final MovieDetailService movieDetailService;
    private final ScheduleOrderService sortingService;

    @Autowired
    public MovieController(MovieService movieService,
                           MovieDetailService movieDetailService,
                           ScheduleOrderService sortingService) {
        this.movieService = movieService;
        this.movieDetailService = movieDetailService;
        this.sortingService = sortingService;
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<MovieDetail> getMovieDetails(@PathVariable("id") int movieId){
        MovieDetail movieDetail = movieDetailService.getMovieDetail(movieId);
        return new ResponseEntity<>(movieDetail, HttpStatus.OK);
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<List<CinemaMovieSchedule>> getSchedule(@PathVariable("id")int movieId){
        List<CinemaMovieSchedule> cinemaMovieSchedules = sortingService.getMovieSchedules(movieId);
        return new ResponseEntity<>(cinemaMovieSchedules, HttpStatus.OK);
    }
}
