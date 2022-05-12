package org.billboard.repository.daoImpl;

import org.billboard.model.Detail;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.DetailDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class DetailDaoImpl implements DetailDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getDetailsByMovieId = "SELECT * FROM detail WHERE movie_id=?";
    private static final String getAllByMovieId = "SELECT * FROM detail";
    private static final String getAllLanguages = "SELECT language FROM detail WHERE movie_id=?";
    private static final String getReleasedDate = "SELECT d.release_date " +
            "FROM detail d, movie m " +
            "WHERE m.movie_id=d.movie_id " +
            "AND m.movie_id=?";

    public DetailDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Date getReleasedDate(int movieId){
        return jdbcTemplate.queryForObject(getReleasedDate, Date.class, movieId);
    }

    @Override
    public List<Detail> getAll() {
        return jdbcTemplate.query(getAllByMovieId, new BeanPropertyRowMapper<>(Detail.class));
    }

    @Override
    public Detail getById(int id) {
        return jdbcTemplate.queryForObject(getDetailsByMovieId,
                new BeanPropertyRowMapper<>(Detail.class), id);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void save(Detail entity, int id) {

    }

    @Override
    public String getLanguage(int movieId) {
        return jdbcTemplate.queryForObject(getAllLanguages, String.class, movieId);
    }
}
