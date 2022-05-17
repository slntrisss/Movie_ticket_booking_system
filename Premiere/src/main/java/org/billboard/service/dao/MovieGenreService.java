package org.billboard.service.dao;

import org.billboard.model.Genre;
import org.billboard.model.MovieGenre;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.GenreDao;
import org.billboard.service.trigger.DeleteEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreService implements DeleteEventListener {
    private final GenreDao genreDao;

    @Autowired
    public MovieGenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public List<Genre> getGenres(int movieId){
        return genreDao.getGenreList(movieId);
    }

    public void save(List<Genre> genres, int movieId){
        genreDao.save(genres, movieId);
    }

    public void delete(int id){
        genreDao.deleteById(id);
    }

    @Override
    public void notifyDelete(int id) {
        delete(id);
    }
}
