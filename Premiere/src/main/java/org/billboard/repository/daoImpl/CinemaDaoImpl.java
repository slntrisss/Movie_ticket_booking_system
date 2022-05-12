package org.billboard.repository.daoImpl;

import org.billboard.model.Cinema;
import org.billboard.repository.dao.CinemaDao;
import org.billboard.repository.daoMapper.CinemaDaoMapper;
import org.billboard.repository.daoMapper.CinemaDetailMapper;
import org.billboard.repository.daoMapper.CinemaOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaDaoImpl implements  CinemaDao<Cinema> {
    private final JdbcTemplate jdbcTemplate;
    private static final String getAllCinemas = "SELECT * FROM cinema";
    private static final String getCinemaById = "SELECT * FROM cinema WHERE cinema_id=?";
    private static final String getCinemaOrder =
            "select distinct c.cinema_name, c.cinema_id, c.address " +
            "from cinema c, cinema_hall ch, schedule s " +
            "where s.cinema_hall_id=ch.cinema_hall_id " +
            "and ch.cinema_id=c.cinema_id " +
            "and s.movie_id=?";
    private static final String getCinemaPosters =
            "SELECT cinema_id, cinema_name, image_file, address, phone " +
            "FROM cinema " +
            "LIMIT ?";
    private final String addNewCinema = "INSERT INTO cinema(cinema_name, address, phone, " +
            "info, start_of_work, end_of_work, image_file) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String exists = "SELECT EXISTS(SELECT cinema_name FROM cinema WHERE " +
            "cinema_name LIKE ?)";

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
        return jdbcTemplate.queryForObject(getCinemaById, new CinemaDetailMapper(), id);
    }

    @Override
    public void save(Cinema cinema) {
        jdbcTemplate.update(addNewCinema, cinema.getCinemaName(), cinema.getAddress(),
                cinema.getPhone(), cinema.getInfo(), cinema.getStartOfWork(),
                cinema.getEndOfWork(), cinema.getImageFile());
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Cinema> getCinemaPosters(Integer rowCount) {
        return jdbcTemplate.query(getCinemaPosters, new CinemaDaoMapper(), rowCount);
    }

    @Override
    public List<Cinema> getCinemaOrders(int id) {
        return jdbcTemplate.query(getCinemaOrder, new CinemaOrderMapper(), id);
    }

    @Override
    public boolean exists(String cinemaName) {
        return Boolean.TRUE.equals(jdbcTemplate.queryForObject(exists, Boolean.class, cinemaName));
    }
}
