package org.billboard.repository.daoImpl;

import org.billboard.dto.home.MoviePoster;
import org.billboard.model.Movie;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements CrudRepository<Movie>, MovieDao {

    private final  JdbcTemplate jdbcTemplate;
    private static final String getAllMovies = "SELECT * FROM movie";
    private static final String getMovieById = "SELECT * FROM movie WHERE movie_id=?";
    private static final String getMoviesToBeSoonReleased = "SELECT m.movie_id, m.movie_name, m.image_file " +
            "FROM movie m, detail d " +
            "WHERE m.movie_id = d.movie_id " +
            "AND current_date<d.release_date";
    private static final String getKidsMovies = "select distinct m.movie_id,  m.movie_name, m.image_file " +
            "from movie m, movie_genre mg, genre g " +
            "where m.movie_id=mg.movie_id " +
            "and mg.genre_id=g.genre_id " +
            "and g.genre_type IN ('cartoon', 'animation', 'family movie')";
    @Autowired
    public MovieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(getAllMovies, new BeanPropertyRowMapper<>(Movie.class));
    }

    @Override
    public Movie findOneById(int id) {
        return jdbcTemplate.queryForObject(getMovieById, new BeanPropertyRowMapper<>(Movie.class), id);
    }

    @Override
    public void save(Movie entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Movie> getMovieToBeSoonReleased() {
        return jdbcTemplate.query(getMoviesToBeSoonReleased, new BeanPropertyRowMapper<>(Movie.class));
    }

    @Override
    public List<Movie> getKidsMovies() {
        return jdbcTemplate.query(getKidsMovies, new BeanPropertyRowMapper<>(Movie.class));
    }
}
