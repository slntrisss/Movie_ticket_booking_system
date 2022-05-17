package org.billboard.repository.dao;

import org.billboard.filter.ScheduleFilter;
import org.billboard.model.Schedule;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> getSchedules(int movieId, int cinemaId);
    List<Schedule> getSchedules(int movieId);
    List<Schedule> getSchedulesByFilter(ScheduleFilter filter);
    List<Schedule> getAvailableTimeIntervals(ScheduleFilter filter);
    void save(List<Schedule> schedules, int cinemaHallId, int movieId);
}
