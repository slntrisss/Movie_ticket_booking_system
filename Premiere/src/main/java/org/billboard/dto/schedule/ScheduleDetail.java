package org.billboard.dto.schedule;

import org.billboard.model.Schedule;
import org.billboard.model.TicketType;

import java.util.List;

public class ScheduleDetail {
    private List<Schedule> schedules;
    private List<TicketType> ticketTypes;

    public ScheduleDetail() {
    }

    public ScheduleDetail(List<Schedule> schedules, List<TicketType> ticketTypes) {
        this.schedules = schedules;
        this.ticketTypes = ticketTypes;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }
}
