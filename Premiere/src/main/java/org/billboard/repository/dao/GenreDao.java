package org.billboard.repository.dao;

import org.billboard.model.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getGenreList(int movieId);
}
