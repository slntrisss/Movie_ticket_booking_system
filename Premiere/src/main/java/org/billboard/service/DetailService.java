package org.billboard.service;

import org.billboard.model.Detail;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.DetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DetailService {
    private final CrudRepository<Detail> detailRepo;
    private final DetailDao detailDao;

    @Autowired
    public DetailService(CrudRepository<Detail> detailRepo,
                         DetailDao detailDao) {
        this.detailRepo = detailRepo;
        this.detailDao = detailDao;
    }

    public Date getReleasedDate(int movieId){
        return detailDao.getReleasedDate(movieId);
    }
}
