package org.billboard.repository.dao;

import org.billboard.model.Detail;

import java.util.Date;
import java.util.List;

public interface DetailDao {
    Date getReleasedDate(int movieId);
    List<Detail> getAll();
    Detail getById(int id);
    void deleteById(int id);
    void save(Detail detail, int id);
    void update(Detail detail);
    String getLanguage(int movieId);
    Integer getLastId();
    Integer getDuration(int movieId);

}
