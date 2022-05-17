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
    public ResponseEntity<List<Cinema>> getAllCinemas(@RequestParam(value = "limit",
            required = false) String limit){
        List<Cinema> cinemas = cinemaService.getCinemaPosters(limit);
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("detail/{cinemaId}")
    public ResponseEntity<Cinema> getCinemaDetail(@PathVariable("cinemaId")int cinemaId){
        Cinema cinema = cinemaService.findOneById(cinemaId);
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @PostMapping("/addHalls")
    public ResponseEntity<?> addHalls(@RequestBody List<CinemaHall> halls,
                                      @RequestParam("cinemaId") int cinemaId){
        hallService.save(halls, cinemaId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateCinema")
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

    @GetMapping("hall/detail/{hallId}")
    public ResponseEntity<CinemaHall> getHall(@PathVariable("hallId") int hallId){
        CinemaHall hall = hallService.getHallDetail(hallId);
        return new ResponseEntity<>(hall, HttpStatus.OK);
    }

    @PutMapping("/updateHall")
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

    @DeleteMapping("/delete-cinema/{cinemaId}")
    public ResponseEntity<?> deleteCinema(@PathVariable("cinemaId")int cinemaId){
        cinemaService.addEventListeners(hallService);
        cinemaService.delete(cinemaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-hall/{hallId}")
    public ResponseEntity<?> deleteHall(@PathVariable("hallId") int hallId){
        hallService.delete(hallId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
