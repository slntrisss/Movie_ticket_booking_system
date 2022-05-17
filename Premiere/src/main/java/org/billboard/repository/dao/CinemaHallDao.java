package org.billboard.repository.dao;

import org.billboard.model.CinemaHall;

import java.util.List;

public interface CinemaHallDao {
    List<String> getHalls(int cinemaId);
    String getHall(int scheduleId);
    void save(List<CinemaHall> cinemaHalls, int cinemaId);
    List<CinemaHall> getAvailableHallsByCinema(int cinemaId);
    List<Integer> getSchedules(int id);
    CinemaHall getHallDetail(int hallId);
    void update(CinemaHall hall, int cinemaId);
    void delete(int id);
}
