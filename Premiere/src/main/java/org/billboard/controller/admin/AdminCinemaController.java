package org.billboard.controller.admin;

import org.billboard.error.Error;
import org.billboard.error.exception.InvalidCinemaException;
import org.billboard.model.Cinema;
import org.billboard.service.dao.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/cinema")
public class AdminCinemaController {
    private final CinemaService cinemaService;

    public AdminCinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping("/add")
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
}
