package org.billboard.service.dao;

import org.billboard.model.Detail;
import org.billboard.repository.dao.DetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DetailService {
    private final DetailDao detailRepo;

    @Autowired
    public DetailService(DetailDao detailDao) {
        this.detailRepo = detailDao;
    }

    public Date getReleasedDate(int movieId){
        return detailRepo.getReleasedDate(movieId);
    }

    public Detail getDetailsByMovieId(int movieId){
        return detailRepo.getById(movieId);
    }

    public String getAllLanguages(int movieId){
        return detailRepo.getLanguage(movieId);
    }

    public void save(Detail detail, int movieId){
        detailRepo.save(detail, movieId);
    }

    public void update(Detail detail){
        detailRepo.update(detail);
    }

    public Integer getLastId(){
        return detailRepo.getLastId();
    }

    public Integer getDuration(int movieId){
        return detailRepo.getDuration(movieId);
    }
}
