package org.billboard.repository.dao;

import org.billboard.model.Cinema;

import java.io.Serializable;
import java.util.List;

public interface CinemaDao<T extends Serializable> extends CrudRepository<T>  {
    List<Cinema> getCinemaPosters(Integer rowCount);
    List<Cinema> getCinemaOrders(int id);
    boolean exists(String cinemaName);
    List<Cinema> getCinemaNames();
}
