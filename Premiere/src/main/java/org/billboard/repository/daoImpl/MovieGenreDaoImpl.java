package org.billboard.repository.daoImpl;

import org.billboard.model.Genre;
import org.billboard.repository.dao.GenreDao;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MovieGenreDaoImpl implements GenreDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getAllMovieGenres = "SELECT * FROM movie_genre";
    private static final String getAllGenres = "SELECT g.genre_id, g.genre_type " +
            "FROM genre g, movie m, movie_genre mg " +
            "WHERE m.movie_id=mg.movie_id " +
            "AND mg.genre_id=g.genre_id " +
            "AND m.movie_id=?";
    private static final String saveGenresByMovieId = "INSERT INTO movie_genre(MOVIE_ID, GENRE_ID) " +
            "VALUES(?, ?) ";
    private static final String deleteById = "DELETE FROM movie_genre WHERE movie_id=?";
    public MovieGenreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Genre> getGenreList(int movieId) {
        return jdbcTemplate.query(getAllGenres, new BeanPropertyRowMapper<>(Genre.class), movieId);
    }

    @Override
    public void save(final List<Genre> genres, final int movieId) {
        jdbcTemplate.batchUpdate(saveGenresByMovieId, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(movieId, genres.get(i).getGenreId());
            }

            @Override
            public int getBatchSize() {
                return genres.size();
            }
        });
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(deleteById, id);
    }
}
