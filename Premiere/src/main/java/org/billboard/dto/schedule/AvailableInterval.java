package org.billboard.dto.schedule;

import java.util.LinkedList;
import java.util.List;

public class AvailableInterval {
    String from;
    String to;

    public AvailableInterval() {

    }

    public AvailableInterval(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
