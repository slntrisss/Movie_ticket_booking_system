package org.billboard.dto.book;

import org.billboard.model.Booking;
import org.billboard.model.CinemaSeat;
import org.billboard.model.Schedule;
import org.billboard.model.User;

public class BookedTicket {
    private Booking booking;
    private User user;
    private Schedule schedule;
    private CinemaSeat seat;

    public BookedTicket() {
    }

    public BookedTicket(Booking booking,
                        User user,
                        Schedule schedule,
                        CinemaSeat seat) {
        this.booking = booking;
        this.user = user;
        this.schedule = schedule;
        this.seat = seat;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public CinemaSeat getSeat() {
        return seat;
    }

    public void setSeat(CinemaSeat seat) {
        this.seat = seat;
    }
}
