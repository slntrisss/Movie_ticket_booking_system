package org.billboard.service.dao;

import org.billboard.error.exception.InvalidHallException;
import org.billboard.model.Cinema;
import org.billboard.model.CinemaHall;
import org.billboard.repository.dao.CinemaHallDao;
import org.billboard.service.trigger.DeleteEventListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CinemaHallService implements DeleteEventListener {
    private final CinemaHallDao hallRepo;
    private final ScheduleService scheduleService;

    public CinemaHallService(CinemaHallDao hallRepo,
                             ScheduleService scheduleService) {
        this.hallRepo = hallRepo;
        this.scheduleService = scheduleService;
    }

    public String getHallByScheduleId(int scheduleId){
        return hallRepo.getHall(scheduleId);
    }

    public List<String> getHallsByCinemaId(int cinemaId){
        return hallRepo.getHalls(cinemaId);
    }

    public CinemaHall getHallDetail(int hallId){
        return hallRepo.getHallDetail(hallId);
    }

    public void save(List<CinemaHall> cinemaHalls, int cinemaId){
        List<CinemaHall> nonDuplicateList = removeDuplicates(cinemaHalls, cinemaId);
        hallRepo.save(nonDuplicateList, cinemaId);
    }

    public void update(CinemaHall cinemaHall, int cinemaId) throws InvalidHallException {
        hallRepo.update(cinemaHall, cinemaId);
    }

    public void delete(int hallId){
        scheduleService.deleteByHallId(hallId);
        hallRepo.delete(hallId);
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

    @Override
    public void notifyDelete(int id) {
        List<Integer> list = hallRepo.getSchedules(id);
        for(Integer e: list)
            scheduleService.notifyDelete(e);
        hallRepo.delete(id);
    }
}
