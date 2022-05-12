package org.billboard.repository.dao;

import org.billboard.model.Schedule;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> getSchedules(int movieId, int cinemaId);
    List<Schedule> getSchedules(int movieId);
}
