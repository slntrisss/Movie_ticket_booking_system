package org.billboard.controller.cinema;

import org.billboard.dto.scheduleSort.CinemaMovieSchedule;
import org.billboard.model.Cinema;
import org.billboard.service.dao.CinemaService;
import org.billboard.service.dto.ScheduleOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    private final CinemaService cinemaService;
    private final ScheduleOrderService sortingService;

    public CinemaController(CinemaService cinemaService,
                            ScheduleOrderService sortingService) {
        this.cinemaService = cinemaService;
        this.sortingService = sortingService;
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Cinema> getCinema(@PathVariable("id") int cinemaId){
        Cinema cinema = cinemaService.findOneById(cinemaId);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<List<CinemaMovieSchedule>> getSchedules(@PathVariable("id")int cinemaId){
        List<CinemaMovieSchedule> schedules = sortingService.getCinemaSchedule(cinemaId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
}
