package org.billboard.model;

import java.io.Serializable;

public class TicketType implements Serializable {
    private Integer adultTicket;
    private Integer childTicket;
    private Integer studentTicket;

    public TicketType() {
    }

    public TicketType(Integer adultTicket,
                      Integer childTicket,
                      Integer studentTicket) {
        this.adultTicket = adultTicket;
        this.childTicket = childTicket;
        this.studentTicket = studentTicket;
    }

    public Integer getAdultTicket() {
        return adultTicket;
    }

    public void setAdultTicket(Integer adultTicket) {
        this.adultTicket = adultTicket;
    }

    public Integer getChildTicket() {
        return childTicket;
    }

    public void setChildTicket(Integer childTicket) {
        this.childTicket = childTicket;
    }

    public Integer getStudentTicket() {
        return studentTicket;
    }

    public void setStudentTicket(Integer studentTicket) {
        this.studentTicket = studentTicket;
    }
}
