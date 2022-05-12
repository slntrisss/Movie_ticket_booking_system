package org.billboard.service.dao;

import org.billboard.model.Schedule;
import org.billboard.repository.dao.ScheduleDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleDao scheduleRepo;

    public ScheduleService(ScheduleDao scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    public List<Schedule> getSchedules(int movieId, int cinemaId){
        return scheduleRepo.getSchedules(movieId, cinemaId);
    }

    public List<Schedule> getSchedules(int movieId){
        return scheduleRepo.getSchedules(movieId);
    }
}
