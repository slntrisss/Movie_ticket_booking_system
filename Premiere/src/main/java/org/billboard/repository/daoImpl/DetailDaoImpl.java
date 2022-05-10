package org.billboard.repository.daoImpl;

import org.billboard.model.Detail;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.DetailDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class DetailDaoImpl implements CrudRepository<Detail>, DetailDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getReleasedDate = "SELECT d.release_date " +
            "FROM detail d, movie m " +
            "WHERE m.movie_id=d.movie_id " +
            "AND m.movie_id=?";

    public DetailDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Detail> getAll() {
        return null;
    }

    @Override
    public Detail findOneById(int id) {
        return null;
    }

    @Override
    public void save(Detail entity) {

    }

    @Override
    public void delete(int id) {

    }

    public Date getReleasedDate(int movieId){
        return jdbcTemplate.queryForObject(getReleasedDate, Date.class, movieId);
    }
}
