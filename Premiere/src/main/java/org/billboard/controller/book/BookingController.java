package org.billboard.controller.book;

import org.billboard.dto.book.BookedSchedule;
import org.billboard.dto.book.BookingDetail;
import org.billboard.filter.BookingFilter;
import org.billboard.service.book.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping()
    public ResponseEntity<BookingDetail> getBookingDetail(@RequestBody BookingFilter filter){
        BookingDetail bookingDetail = bookingService.getBookingDetail(filter);
        return new ResponseEntity<>(bookingDetail, HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<?> reserve(@RequestBody BookedSchedule schedule){
        bookingService.reserveSeats(schedule);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
