package org.billboard.controller.admin;

import org.billboard.dto.schedule.AvailableInterval;
import org.billboard.dto.schedule.ScheduleDetail;
import org.billboard.filter.ScheduleFilter;
import org.billboard.model.Cinema;
import org.billboard.model.CinemaHall;
import org.billboard.model.Movie;
import org.billboard.service.dao.CinemaHallService;
import org.billboard.service.dao.CinemaService;
import org.billboard.service.dao.MovieService;
import org.billboard.service.dao.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/schedule")
public class AdminScheduleController {
    private final CinemaService cinemaService;
    private final MovieService movieService;
    private final CinemaHallService hallService;
    private final ScheduleService scheduleService;

    public AdminScheduleController(CinemaService cinemaService,
                                   MovieService movieService,
                                   CinemaHallService hallService,
                                   ScheduleService scheduleService) {
        this.cinemaService = cinemaService;
        this.movieService = movieService;
        this.hallService = hallService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/availableCinemas")
    public ResponseEntity<List<Cinema>> getAvailableCinemas(){
        List<Cinema> cinemas = cinemaService.getCinemaNames();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/availableMovies")
    public ResponseEntity<List<Movie>> getAvailableMovies(){
        List<Movie> movies = movieService.getAvailableMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/availableHalls/{id}")
    public ResponseEntity<List<CinemaHall>> getAvailableHalls(@PathVariable("id") int id){
        List<CinemaHall> halls = hallService.getAvailableHalls(id);
        return new ResponseEntity<>(halls, HttpStatus.OK);
    }

    @PostMapping("/listOfAvailableSchedules")
    public ResponseEntity<ScheduleDetail> getAvailableSchedules(@RequestBody ScheduleFilter filter){
        ScheduleDetail schedule = scheduleService.getSchedulesByFilter(filter);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PostMapping("/availableIntervals")
    public ResponseEntity<List<AvailableInterval>> getAvailableIntervals(@RequestBody ScheduleFilter filter){
        List<AvailableInterval> availableIntervals = scheduleService.getAvailableIntervals(filter);
        return new ResponseEntity<>(availableIntervals, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveSchedules(@RequestBody ScheduleDetail schedule,
                                           @RequestParam("cinemaHallId") int cinemaHallId,
                                           @RequestParam("movieId") int movieId){
        scheduleService.saveSchedules(schedule, cinemaHallId, movieId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{scheduleId}")
    public ResponseEntity<?> delete(@PathVariable("scheduleId") int scheduleId){
        scheduleService.delete(scheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
