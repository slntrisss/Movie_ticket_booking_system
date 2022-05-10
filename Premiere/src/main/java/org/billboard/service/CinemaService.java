package org.billboard.service;

import org.billboard.model.Cinema;
import org.billboard.repository.dao.CinemaDao;
import org.billboard.repository.dao.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    private final CrudRepository<Cinema> cinemaRepo;
    private final CinemaDao cinemaDao;

    @Autowired
    public CinemaService(CrudRepository<Cinema> cinemaRepo,
                         CinemaDao cinemaDao) {
        this.cinemaRepo = cinemaRepo;
        this.cinemaDao = cinemaDao;
    }

    public List<Cinema> getAllCinemas(){
        return cinemaRepo.getAll();
    }

    public Cinema getCinemaById(int cinemaId){
        return cinemaRepo.findOneById(cinemaId);
    }

    public List<Cinema> getCinemaPosters(String limit){
        if(limit == null || limit.length() == 0)
            return cinemaDao.getCinemaPosters(null);
        else {
            Integer rowCount = Integer.parseInt(limit);
            return cinemaDao.getCinemaPosters(rowCount);
        }
    }
}
