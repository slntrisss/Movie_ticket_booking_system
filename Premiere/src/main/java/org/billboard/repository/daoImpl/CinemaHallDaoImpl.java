package org.billboard.repository.daoImpl;

import org.billboard.model.CinemaHall;
import org.billboard.repository.dao.CinemaHallDao;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    private static final String saveHalls = "INSERT INTO cinema_hall(hall_name, number_of_rows, " +
            "number_of_cols, cinema_id) VALUES (?, ?, ?, ?)";

    private static final String getHallsByCinemaId = "SELECT hall_name FROM cinema_hall " +
            "JOIN cinema c " +
            "    ON c.cinema_id = cinema_hall.cinema_id " +
            "WHERE c.cinema_id=?";

    private static final String getAvailableHallsByCinema = "SELECT cinema_hall_id, hall_name " +
            "FROM cinema_hall WHERE cinema_id=?";
    private static final String updateHall = "UPDATE cinema_hall SET hall_name=?," +
            "number_of_halls=?, number_of_rows=?, number_of_cols=? WHERE " +
            "cinema_hall_id=? and cinema_id=?";

    public CinemaHallDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> getHalls(int cinemaId) {
        return jdbcTemplate.queryForList(getHallsByCinemaId, String.class, cinemaId);
    }

    @Override
    public String getHall(int scheduleId) {
        return jdbcTemplate.queryForObject(getHallByScheduleId, String.class, scheduleId);
    }

    @Override
    public void save(final List<CinemaHall> cinemaHalls, final int cinemaId) {
        jdbcTemplate.batchUpdate(saveHalls, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, cinemaHalls.get(i).getHallName());
                ps.setInt(2, cinemaHalls.get(i).getNumberOfRows());
                ps.setInt(3, cinemaHalls.get(i).getNumberOfCols());
                ps.setInt(4, cinemaId);
            }

            @Override
            public int getBatchSize() {
                return cinemaHalls.size();
            }
        });
    }

    @Override
    public List<CinemaHall> getAvailableHallsByCinema(int cinemaId) {
        return jdbcTemplate.query(getAvailableHallsByCinema,
                new BeanPropertyRowMapper<>(CinemaHall.class), cinemaId);
    }

    @Override
    public void update(CinemaHall hall, int cinemaId) {
        jdbcTemplate.update(updateHall, hall.getHallName(), hall.getNumberOfRows(),
                hall.getNumberOfCols(), hall.getCinemaHallId(), cinemaId);
    }
}
