package org.billboard.controller.admin;

import org.billboard.error.Error;
import org.billboard.error.exception.InvalidCinemaException;
import org.billboard.error.exception.InvalidHallException;
import org.billboard.model.Cinema;
import org.billboard.model.CinemaHall;
import org.billboard.service.dao.CinemaHallService;
import org.billboard.service.dao.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/cinema")
public class AdminCinemaController {
    private final CinemaService cinemaService;
    private final CinemaHallService hallService;

    public AdminCinemaController(CinemaService cinemaService,
                                 CinemaHallService hallService) {
        this.cinemaService = cinemaService;
        this.hallService = hallService;
    }

    @PostMapping("/addCinema")
    @ExceptionHandler(InvalidCinemaException.class)
    public ResponseEntity<?> addCinema(@RequestBody Cinema cinema){
        try {
            cinemaService.save(cinema);
        } catch (InvalidCinemaException e) {
            Error error = new Error(HttpStatus.NOT_MODIFIED, e.getMessage());
            return new ResponseEntity<>(error, error.getHttpStatus());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/availableCinemas")
    public ResponseEntity<List<Cinema>> getAllCinemas(){
        List<Cinema> cinemas = cinemaService.getCinemaNames();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @PostMapping("/addHalls")
    public ResponseEntity<?> addHalls(@RequestBody List<CinemaHall> halls,
                                      @RequestParam("cinemaId") int cinemaId){
        hallService.save(halls, cinemaId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateCinema")
    @ExceptionHandler(InvalidCinemaException.class)
    public ResponseEntity<?> updateCinema(@RequestBody Cinema cinema){
        try {
            cinemaService.update(cinema);
        } catch (InvalidCinemaException e) {
            Error error = new Error(HttpStatus.NOT_MODIFIED, e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAvailableHalls/{cinemaId}")
    public ResponseEntity<List<CinemaHall>> getAvailableHalls(@PathVariable("cinemaId") int cinemaId){
        List<CinemaHall> halls = hallService.getAvailableHalls(cinemaId);
        return new ResponseEntity<>(halls, HttpStatus.OK);
    }

    @PutMapping("/updateHalls")
    @ExceptionHandler(InvalidHallException.class)
    public ResponseEntity<?> updateHall(@RequestBody CinemaHall cinemaHall,
                                        @RequestParam("cinemaId") int cinemaId){
        try {
            hallService.update(cinemaHall, cinemaId);
        } catch (InvalidHallException e) {
            Error error = new Error(HttpStatus.NOT_MODIFIED, e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
