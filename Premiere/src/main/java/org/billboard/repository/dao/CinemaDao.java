package org.billboard.repository.dao;

import org.billboard.model.Cinema;

import java.util.List;

public interface CinemaDao {
    List<Cinema> getCinemaPosters(Integer rowCount);
}
