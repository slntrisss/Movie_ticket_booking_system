package org.billboard.repository.daoImpl;

import org.billboard.repository.dao.CinemaHallDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaHallDaoImpl implements CinemaHallDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getHallsById =
            "SELECT hall_name FROM cinema_hall " +
                    "JOIN schedule s " +
                    "    ON cinema_hall.cinema_hall_id = s.cinema_hall_id " +
                    "JOIN movie m " +
                    "     ON m.movie_id = s.movie_id " +
                    "WHERE m.movie_id=? " +
                    "AND cinema_id=?";
    private static final String getHallsByMovieId = "SELECT hall_name FROM cinema_hall " +
            "LEFT JOIN schedule s " +
            "    ON cinema_hall.cinema_hall_id = s.cinema_hall_id " +
            "WHERE movie_id=?";

    private static final String getHallByScheduleId = "SELECT hall_name FROM cinema_hall " +
            "JOIN schedule s " +
            "    ON cinema_hall.cinema_hall_id = s.cinema_hall_id " +
            "WHERE schedule_id=?";

    public CinemaHallDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getHalls(int movieId, int cinemaId) {
        return jdbcTemplate.queryForList(getHallsById, String.class, movieId, cinemaId);
    }

    @Override
    public List<String> getHalls(int movieId) {
        return jdbcTemplate.queryForList(getHallsByMovieId, String.class, movieId);
    }

    @Override
    public String getHall(int scheduleId) {
        return jdbcTemplate.queryForObject(getHallByScheduleId, String.class, scheduleId);
    }
}
