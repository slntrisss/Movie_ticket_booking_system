package org.billboard.model;

import java.util.Date;

public class Booking {
    private int bookingId;
    private Date paymentDate;
    private int price;

    public Booking() {
    }

    public Booking(int bookingId, Date paymentDate, int price) {
        this.bookingId = bookingId;
        this.paymentDate = paymentDate;
        this.price = price;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
