package org.billboard.service.dao;

import org.billboard.error.exception.InvalidCinemaException;
import org.billboard.model.Cinema;
import org.billboard.repository.dao.CinemaDao;
import org.billboard.service.trigger.DeleteEventListener;
import org.billboard.service.validator.CinemaValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaService {
    private final CinemaDao<Cinema> cinemaRepo;
    private final CinemaValidatorService validatorService;
    private List<DeleteEventListener> eventListeners = new ArrayList<>();

    @Autowired
    public CinemaService(CinemaDao<Cinema> cinemaDao,
                         CinemaValidatorService validatorService) {
        this.cinemaRepo = cinemaDao;
        this.validatorService = validatorService;
    }

    public List<Cinema> getCinemaPosters(String limit){
        if(limit == null || limit.length() == 0)
            return cinemaRepo.getCinemaPosters(null);
        else {
            Integer rowCount = Integer.parseInt(limit);
            return cinemaRepo.getCinemaPosters(rowCount);
        }
    }

    public List<Cinema> getCinemaNames(){
        return cinemaRepo.getCinemaNames();
    }

    public Cinema findOneById(int cinemaId){
        return cinemaRepo.findOneById(cinemaId);
    }

    public List<Cinema> getCinemaOrders(int movieId){
        return cinemaRepo.getCinemaOrders(movieId);
    }

    public void save(Cinema cinema) throws InvalidCinemaException {
        boolean valid = validatorService.validateCinema(cinema);
        if(valid)
            cinemaRepo.save(cinema);
    }

    public void update(Cinema cinema) throws InvalidCinemaException {
        boolean valid = validatorService.phoneVerification(cinema);
        if(valid)
            cinemaRepo.update(cinema);
    }

    public void delete(int cinemaId){
        for(DeleteEventListener eventListener: eventListeners)
            eventListener.notifyDelete(cinemaId);
        cinemaRepo.delete(cinemaId);
    }

    public void addEventListeners(DeleteEventListener eventListener){
        eventListeners.add(eventListener);
    }

    public void removeEventListener(DeleteEventListener eventListener){
        eventListeners.remove(eventListener);
    }
}
