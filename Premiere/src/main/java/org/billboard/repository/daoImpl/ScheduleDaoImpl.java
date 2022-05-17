package org.billboard.repository.daoImpl;

import org.billboard.filter.ScheduleFilter;
import org.billboard.model.Schedule;
import org.billboard.repository.dao.ScheduleDao;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    private static final String getSchedulesByFilter =
            "select s.schedule_id, s.schedule_date, s.start_time from schedule s " +
            "join movie m " +
            "    on m.movie_id = s.movie_id " +
            "join cinema_hall ch " +
            "    on ch.cinema_hall_id = s.cinema_hall_id " +
            "join cinema c " +
            "    on c.cinema_id = ch.cinema_id " +
            "where c.cinema_id=? " +
            "and m.movie_id=? " +
            "and ch.cinema_hall_id=?";
    private static final String getAvailableTimeIntervals =
            "select s.schedule_id, s.schedule_date, s.start_time from schedule s " +
            "join movie m " +
            "    on m.movie_id = s.movie_id " +
            "join cinema_hall ch " +
            "    on ch.cinema_hall_id = s.cinema_hall_id " +
            "join cinema c " +
            "    on c.cinema_id = ch.cinema_id " +
            "where c.cinema_id=? " +
            "and ch.cinema_hall_id=? " +
                    "order by start_time";
    private static final String saveSchedules =
            "insert into schedule(schedule_date, start_time, cinema_hall_id, movie_id) " +
                    "values(?,?,?,?)";
    private static final String delete = "DELETE FROM schedule WHERE schedule_id=?";
    private static final String deleteByMovieId = "DELETE FROM schedule WHERE movie_id=?";
    private static final String getSchedulesByHallId = "SELECT schedule_id " +
            "FROM schedule WHERE cinema_hall_id=?";
    private static final String deleteByHallId = "DELETE FROM schedule WHERE cinema_hall_id=?";

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

    @Override
    public List<Schedule> getSchedulesByFilter(ScheduleFilter filter) {
        return jdbcTemplate.query(getSchedulesByFilter,
                new BeanPropertyRowMapper<>(Schedule.class),filter.getCinemaId(),
                filter.getMovieId(), filter.getCinemaHallId());
    }

    public List<Schedule> getAvailableTimeIntervals(ScheduleFilter filter){
        return jdbcTemplate.query(getAvailableTimeIntervals,
                new BeanPropertyRowMapper<>(Schedule.class),
                filter.getCinemaId(), filter.getCinemaHallId());
    }

    @Override
    public List<Integer> getSchedulesByHallId(int hallId) {
        return jdbcTemplate.queryForList(getSchedulesByHallId, Integer.class,
                hallId);
    }

    @Override
    public void save(final List<Schedule> schedules, final int cinemaHallId, final int movieId) {
        jdbcTemplate.batchUpdate(saveSchedules, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setDate(1,  new Date(schedules.get(i).getScheduleDate().getTime()));
                ps.setString(2, schedules.get(i).getStartTime());
                ps.setInt(3, cinemaHallId);
                ps.setInt(4, movieId);
            }

            @Override
            public int getBatchSize() {
                return schedules.size();
            }
        });
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(delete, id);
    }

    @Override
    public void deleteByMovieId(int movieId) {
        jdbcTemplate.update(deleteByMovieId, movieId);
    }

    @Override
    public void deleteByHallId(int hallId) {
        jdbcTemplate.update(deleteByHallId, hallId);
    }
}
