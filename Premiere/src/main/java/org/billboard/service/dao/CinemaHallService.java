package org.billboard.service.dao;

import org.billboard.repository.dao.CinemaHallDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallService {
    private final CinemaHallDao hallRepo;

    public CinemaHallService(CinemaHallDao hallRepo) {
        this.hallRepo = hallRepo;
    }

    public List<String> getHalls(int movieId, int cinemaId){
        return hallRepo.getHalls(movieId, cinemaId);
    }

    public List<String> getHalls(int movieId){
        return hallRepo.getHalls(movieId);
    }

    public String getHallByScheduleId(int scheduleId){
        return hallRepo.getHall(scheduleId);
    }
}
