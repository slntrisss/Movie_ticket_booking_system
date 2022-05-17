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
public class MovieDaoImpl implements MovieDao<Movie> {

    private final  JdbcTemplate jdbcTemplate;
    private static final String getAllMovies = "SELECT * FROM movie";
    private static final String getMovieById = "SELECT * FROM movie WHERE movie_id=?";
    private static final String getMoviesToBeSoonReleased = "SELECT m.movie_id, m.movie_name, m.image_file " +
            "FROM movie m, detail d " +
            "WHERE m.movie_id = d.movie_id " +
            "AND current_date<d.release_date";
    private static final String getKidsMovies = "SELECT DISTINCT m.movie_id,  m.movie_name, m.image_file " +
            "FROM movie m, movie_genre mg, genre g " +
            "WHERE m.movie_id=mg.movie_id " +
            "AND mg.genre_id=g.genre_id " +
            "AND g.genre_type IN ('cartoon', 'animation', 'family movie')";
    private static final String getAllMoviesByCinemaId =
            "SELECT DISTINCT m.movie_id, m.movie_name, m.image_file " +
            "FROM movie m " +
            "JOIN schedule s " +
            "    ON m.movie_id = s.movie_id " +
            "JOIN cinema_hall ch " +
            "    ON ch.cinema_hall_id = s.cinema_hall_id " +
            "JOIN cinema c " +
            "    ON c.cinema_id = ch.cinema_id " +
            "WHERE c.cinema_id=?";
    private static final String exists = "select exists( " +
            "    select * from movie " +
            "    where movie_name like ? " +
            "    OR original_name like ? " +
            "    OR image_file like ? " +
            "    )";
    private static final String lastId = "SELECT max(movie_id) FROM movie";
    private static final String availableMovies = "SELECT movie_id, movie_name FROM movie";
    private static final String updateMovie = "UPDATE movie SET movie_name=?, " +
            "original_name=?, image_file=? WHERE movie_id=?";
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
    public void update(Movie movie) {
        jdbcTemplate.update(updateMovie, movie.getMovieName(),
                movie.getOriginalName(), movie.getImageFile(),
                movie.getMovieId());
    }

    @Override
    public List<Movie> getMovieToBeSoonReleased() {
        return jdbcTemplate.query(getMoviesToBeSoonReleased,
                new BeanPropertyRowMapper<>(Movie.class));
    }

    @Override
    public List<Movie> getKidsMovies() {
        return jdbcTemplate.query(getKidsMovies,
                new BeanPropertyRowMapper<>(Movie.class));
    }

    @Override
    public List<Movie> getAllMoviesByCinemaId(int cinemaId) {
        return jdbcTemplate.query(getAllMoviesByCinemaId,
                new BeanPropertyRowMapper<>(Movie.class), cinemaId);
    }

    public boolean exists(Movie movie){
        return Boolean.TRUE.equals(jdbcTemplate.queryForObject(exists, Boolean.class,
                movie.getMovieName(), movie.getOriginalName(), movie.getImageFile()));
    }

    @Override
    public Integer getLastId() {
        return jdbcTemplate.queryForObject(lastId, Integer.class);
    }

    @Override
    public List<Movie> getAvailableCinemas() {
        return jdbcTemplate.query(availableMovies,
                new BeanPropertyRowMapper<>(Movie.class));
    }
}
