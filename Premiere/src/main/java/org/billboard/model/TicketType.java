package org.billboard.model;

import java.io.Serializable;

public class TicketType implements Serializable {
    private int adultTicket;
    private int childTicket;
    private int studentTicket;

    public TicketType() {
    }

    public TicketType(int adultTicket,
                      int childTicket,
                      int studentTicket) {
        this.adultTicket = adultTicket;
        this.childTicket = childTicket;
        this.studentTicket = studentTicket;
    }

    public int getAdultTicket() {
        return adultTicket;
    }

    public void setAdultTicket(int adultTicket) {
        this.adultTicket = adultTicket;
    }

    public int getChildTicket() {
        return childTicket;
    }

    public void setChildTicket(int childTicket) {
        this.childTicket = childTicket;
    }

    public int getStudentTicket() {
        return studentTicket;
    }

    public void setStudentTicket(int studentTicket) {
        this.studentTicket = studentTicket;
    }
}
