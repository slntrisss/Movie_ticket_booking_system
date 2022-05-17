package org.billboard.repository.dao;

import org.billboard.model.CinemaSeat;

import java.util.List;

public interface CinemaSeatDao {
    List<CinemaSeat> getReservedSeats(int scheduleId);
    void reserve(List<CinemaSeat> seats, int cinemaHallId, int scheduleId);
}
