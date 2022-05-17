package org.billboard.service.dao;

import org.billboard.error.exception.InvalidHallException;
import org.billboard.model.CinemaHall;
import org.billboard.repository.dao.CinemaHallDao;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class CinemaHallService {
    private final CinemaHallDao hallRepo;

    public CinemaHallService(CinemaHallDao hallRepo) {
        this.hallRepo = hallRepo;
    }

    public String getHallByScheduleId(int scheduleId){
        return hallRepo.getHall(scheduleId);
    }

    public List<String> getHallsByCinemaId(int cinemaId){
        return hallRepo.getHalls(cinemaId);
    }

    public void save(List<CinemaHall> cinemaHalls, int cinemaId){
        List<CinemaHall> nonDuplicateList = removeDuplicates(cinemaHalls, cinemaId);
        hallRepo.save(nonDuplicateList, cinemaId);
    }

    public void update(CinemaHall cinemaHall, int cinemaId) throws InvalidHallException {
        boolean valid = isValid(cinemaHall, cinemaId);
        if(!valid)
            throw new InvalidHallException("Given hall is already exists");
        hallRepo.update(cinemaHall, cinemaId);
    }

    public List<CinemaHall> getAvailableHalls(int cinemaId){
        return hallRepo.getAvailableHallsByCinema(cinemaId);
    }

    private List<CinemaHall> removeDuplicates(List<CinemaHall> cinemaHalls, int cinemaId){
        List<String> availableHalls = getHallsByCinemaId(cinemaId);
        Set<String> set = new HashSet<>(availableHalls);

        List<CinemaHall> nonDuplicateList = new LinkedList<>();
        for(CinemaHall hall: cinemaHalls){
            if(!set.contains(hall.getHallName()))
                nonDuplicateList.add(hall);
        }
        return nonDuplicateList;
    }

    private boolean isValid(CinemaHall hall, int cinemaId){
        List<String> availableHalls = getHallsByCinemaId(cinemaId);
        Set<String> set = new HashSet<>(availableHalls);
        return !set.contains(hall.getHallName());
    }
}
