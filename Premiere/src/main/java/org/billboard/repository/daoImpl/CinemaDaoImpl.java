package org.billboard.repository.daoImpl;

import org.billboard.model.Cinema;
import org.billboard.repository.dao.CinemaDao;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.daoMapper.CinemaDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaDaoImpl implements CrudRepository<Cinema>, CinemaDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getAllCinemas = "SELECT * FROM cinema";
    private static final String getCinemaById = "SELECT * FROM cinema WHERE cinema_id=?";
    private static final String getCinemaPosters = "SELECT cinema_id, cinema_name, image_file, address, phone " +
            "FROM cinema " +
            "LIMIT ?";

    @Autowired
    public CinemaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cinema> getAll() {
        return jdbcTemplate.query(getAllCinemas, new BeanPropertyRowMapper<>(Cinema.class));
    }

    @Override
    public Cinema findOneById(int id) {
        return jdbcTemplate.queryForObject(getCinemaById, new BeanPropertyRowMapper<>(Cinema.class), id);
    }

    @Override
    public void save(Cinema entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Cinema> getCinemaPosters(Integer rowCount) {
        return jdbcTemplate.query(getCinemaPosters, new CinemaDaoMapper(), rowCount);
    }
}
