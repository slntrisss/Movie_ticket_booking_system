package org.billboard.repository.daoImpl;

import org.billboard.model.Schedule;
import org.billboard.repository.dao.ScheduleDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getSchedulesById =
            "SELECT s.schedule_id, s.start_time, s.schedule_date FROM schedule s " +
                    "JOIN cinema_hall ch " +
                    "    ON ch.cinema_hall_id = s.cinema_hall_id " +
                    "JOIN cinema c " +
                    "    ON c.cinema_id = ch.cinema_id " +
                    "WHERE movie_id=? " +
                    "AND c.cinema_id=? " +
                    "AND start_time > to_char(localtime, 'HH:MI') " +
                    "AND schedule_date=current_date " +
                    "ORDER BY to_timestamp(s.start_time, 'HH24:MI')";
    private static final String getSchedulesByMovieId = "SELECT * FROM schedule WHERE movie_id=?";

    public ScheduleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Schedule> getSchedules(int movieId, int cinemaId) {
        return jdbcTemplate.query(getSchedulesById,
                new BeanPropertyRowMapper<>(Schedule.class), movieId, cinemaId);
    }

    @Override
    public List<Schedule> getSchedules(int movieId) {
        return jdbcTemplate.query(getSchedulesByMovieId,
                new BeanPropertyRowMapper<>(Schedule.class), movieId);
    }
}
