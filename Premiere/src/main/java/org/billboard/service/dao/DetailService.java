package org.billboard.service.dao;

import org.billboard.model.Detail;
import org.billboard.repository.dao.DetailDao;
import org.billboard.service.trigger.DeleteEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DetailService implements DeleteEventListener {
    private final DetailDao detailRepo;
    private final RoleDetailService roleDetailService;

    @Autowired
    public DetailService(DetailDao detailDao,
                         RoleDetailService roleDetailService) {
        this.detailRepo = detailDao;
        this.roleDetailService = roleDetailService;
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

    @Override
    public void notifyDelete(int id) {
        roleDetailService.delete(detailRepo.getDetailIdByMovie(id));
        detailRepo.deleteById(id);
    }
}
