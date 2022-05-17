package org.billboard.dto.book;

import org.billboard.model.*;

import java.util.Date;
import java.util.List;

public class BookedSchedule {
    private String email;
    private int price;
    private Date paymentDate;
    private User user;
    private List<CinemaSeat> reservedSeats;
    private String movieName;
    private Cinema cinema;
    private CinemaHall hall;
    private Schedule schedule;


    public BookedSchedule() {
    }

    public BookedSchedule(String email,
                          int price,
                          Date paymentDate,
                          User user,
                          List<CinemaSeat> reservedSeats,
                          String movieName,
                          Cinema cinema,
                          CinemaHall hall,
                          Schedule schedule) {
        this.email = email;
        this.price = price;
        this.paymentDate = paymentDate;
        this.user = user;
        this.reservedSeats = reservedSeats;
        this.movieName = movieName;
        this.cinema = cinema;
        this.hall = hall;
        this.schedule = schedule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CinemaSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<CinemaSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public CinemaHall getHall() {
        return hall;
    }

    public void setHall(CinemaHall hall) {
        this.hall = hall;
    }
}
