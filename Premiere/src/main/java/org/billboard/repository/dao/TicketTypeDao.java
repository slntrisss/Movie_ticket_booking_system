package org.billboard.repository.dao;

import org.billboard.model.TicketType;

import java.util.List;


public interface TicketTypeDao {
    TicketType getTicket(int id);
    void save(TicketType ticketType, int scheduleId);
    void delete(int id);
}
