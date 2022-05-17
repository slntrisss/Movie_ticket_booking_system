package org.billboard.service.dao;

import org.billboard.model.CinemaSeat;
import org.billboard.repository.dao.CinemaSeatDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaSeatService {
    private final CinemaSeatDao seatRepo;

    public CinemaSeatService(CinemaSeatDao seatRepo) {
        this.seatRepo = seatRepo;
    }

    public List<CinemaSeat> getReservedSeats(int scheduleId){
        return seatRepo.getReservedSeats(scheduleId);
    }

    public void reserve(List<CinemaSeat> seats, int cinemaHallId, int scheduleId){
        seatRepo.reserve(seats, cinemaHallId, scheduleId);
    }
}
