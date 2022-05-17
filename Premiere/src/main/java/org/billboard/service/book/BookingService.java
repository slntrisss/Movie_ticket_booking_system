package org.billboard.service.book;

import org.billboard.dto.book.BookedSchedule;
import org.billboard.dto.book.BookedTicket;
import org.billboard.dto.book.BookingDetail;
import org.billboard.filter.BookingFilter;
import org.billboard.model.*;
import org.billboard.repository.dao.BookingDao;
import org.billboard.service.dao.*;
import org.billboard.service.email.EmailSenderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final CinemaService cinemaService;
    private final CinemaHallService hallService;
    private final MovieService movieService;
    private final DetailService detailService;
    private final CinemaSeatService seatService;
    private final TicketTypeService ticketTypeService;
    private final BookingDao bookingRepo;
    private final EmailSenderService emailSenderService;
    private final ScheduleService scheduleService;

    public BookingService(CinemaService cinemaService,
                          CinemaHallService hallService,
                          MovieService movieService,
                          DetailService detailService,
                          CinemaSeatService seatService,
                          TicketTypeService ticketTypeService,
                          BookingDao bookingRepo,
                          EmailSenderService emailSenderService,
                          ScheduleService scheduleService) {
        this.cinemaService = cinemaService;
        this.hallService = hallService;
        this.movieService = movieService;
        this.detailService = detailService;
        this.seatService = seatService;
        this.ticketTypeService = ticketTypeService;
        this.bookingRepo = bookingRepo;
        this.emailSenderService = emailSenderService;
        this.scheduleService = scheduleService;
    }

    public BookingDetail getBookingDetail(BookingFilter filter){
        Cinema cinema = cinemaService.getCinemaName(filter.getCinemaId());
        CinemaHall hall = hallService.getCinemaHallName(filter.getCinemaHallId());
        Movie movie = movieService.findOneById(filter.getMovieId());
        Detail detail = detailService.getDetailsByMovieId(movie.getMovieId());
        List<CinemaSeat> reservedSeats = seatService.getReservedSeats(filter.getScheduleId());
        TicketType ticketType = ticketTypeService.getTicket(filter.getScheduleId());
        Schedule schedule = scheduleService.getSchedule(filter.getScheduleId());

        return new BookingDetail(movie,cinema, hall, detail, schedule, ticketType, reservedSeats);
    }

    public void reserveSeats(BookedSchedule bookedSchedule){
        Booking booking = new Booking();
        booking.setPaymentDate(bookedSchedule.getPaymentDate());
        booking.setPrice(bookedSchedule.getPrice());
        bookingRepo.reserve(booking, bookedSchedule.getUser().getUserId(),
                bookedSchedule.getSchedule().getScheduleId());

        List<CinemaSeat> reservedSeats = bookedSchedule.getReservedSeats();
        seatService.reserve(reservedSeats, bookedSchedule.getHall().getCinemaHallId(),
                bookedSchedule.getSchedule().getScheduleId());

        emailSenderService.sendMail(bookedSchedule);
    }

    public List<BookedTicket> getBookedTickets(){

        return null;
    }
}
