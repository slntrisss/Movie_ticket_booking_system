package org.billboard.service.dao;

import org.billboard.model.TicketType;
import org.billboard.repository.dao.TicketTypeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService {
    private final TicketTypeDao ticketsRepo;

    public TicketTypeService(TicketTypeDao ticketsRepo) {
        this.ticketsRepo = ticketsRepo;
    }

    public TicketType getTicket(int scheduleId){
        return ticketsRepo.getTicket(scheduleId);
    }

    public void save(TicketType ticketType, int scheduleId){
        ticketsRepo.save(ticketType, scheduleId);
    }
}
