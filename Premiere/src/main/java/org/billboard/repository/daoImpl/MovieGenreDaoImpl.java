package org.billboard.repository.daoImpl;

import org.billboard.model.Genre;
import org.billboard.model.MovieGenre;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.GenreDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieGenreDaoImpl implements CrudRepository<MovieGenre>, GenreDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getAllMovieGenres = "SELECT * FROM movie_genre";
    private static final String getAllGenres = "SELECT g.genre_id, g.genre_type " +
            "FROM genre g, movie m, movie_genre mg " +
            "WHERE m.movie_id=mg.movie_id " +
            "AND mg.genre_id=g.genre_id " +
            "AND m.movie_id=?";
    public MovieGenreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<MovieGenre> getAll() {
        return jdbcTemplate.query(getAllMovieGenres, new BeanPropertyRowMapper<>(MovieGenre.class));
    }

    @Override
    public MovieGenre findOneById(int id) {
        return null;
    }

    @Override
    public void save(MovieGenre entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Genre> getGenreList(int movieId) {
        return jdbcTemplate.query(getAllGenres, new BeanPropertyRowMapper<>(Genre.class), movieId);
    }
}
