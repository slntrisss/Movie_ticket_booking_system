package org.billboard.dto.book;

import org.billboard.model.*;

import java.util.List;

public class BookingDetail {
    private Movie movie;
    private Cinema cinema;
    private CinemaHall hall;
    private Detail detail;
    private Schedule schedule;
    private TicketType ticketType;
    private List<CinemaSeat> reservedSeats;

    public BookingDetail() {
    }

    public BookingDetail(Movie movie,
                         Cinema cinema,
                         CinemaHall hall,
                         Detail detail,
                         Schedule schedule,
                         TicketType ticketType,
                         List<CinemaSeat> reservedSeats) {
        this.movie = movie;
        this.cinema = cinema;
        this.hall = hall;
        this.detail = detail;
        this.schedule = schedule;
        this.ticketType = ticketType;
        this.reservedSeats = reservedSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public CinemaHall getHall() {
        return hall;
    }

    public void setHall(CinemaHall hall) {
        this.hall = hall;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public List<CinemaSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<CinemaSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
