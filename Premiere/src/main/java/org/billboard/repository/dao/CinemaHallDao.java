package org.billboard.repository.dao;

import java.util.List;

public interface CinemaHallDao {
    List<String> getHalls(int movieId, int cinemaId);
    List<String> getHalls(int movieId);
    String getHall(int scheduleId);
}
