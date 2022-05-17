package org.billboard.repository.dao;

import org.billboard.filter.ScheduleFilter;
import org.billboard.model.Schedule;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> getSchedules(int movieId, int cinemaId);
    List<Schedule> getSchedules(int movieId);
    List<Schedule> getSchedulesByFilter(ScheduleFilter filter);
    List<Schedule> getAvailableTimeIntervals(ScheduleFilter filter);
    List<Integer> getSchedulesByHallId(int hallId);
    void save(List<Schedule> schedules, int cinemaHallId, int movieId);
    void delete(int id);
    void deleteByMovieId(int movieId);
    void deleteByHallId(int hallId);
}
