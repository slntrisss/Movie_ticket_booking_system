package org.billboard.repository.daoImpl;

import org.billboard.model.CinemaSeat;
import org.billboard.repository.dao.CinemaSeatDao;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CinemaSeatDaoImpl implements CinemaSeatDao {
    private final JdbcTemplate jdbcTemplate;

    private static final String getReservedSeats = "SELECT * FROM cinema_seat " +
            "WHERE schedule_id=?";
    private static final String reserve = "insert into " +
            "cinema_seat(reserved_row_number, reserved_seat_number, " +
            "cinema_hall_id, schedule_id, type) values(?, ?, ?, ?, ?)";
    public CinemaSeatDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CinemaSeat> getReservedSeats(int scheduleId) {
        return jdbcTemplate.query(getReservedSeats,
                new BeanPropertyRowMapper<>(CinemaSeat.class), scheduleId);
    }

    @Override
    public void reserve(final List<CinemaSeat> seats, final int cinemaHallId, final int scheduleId) {
        jdbcTemplate.batchUpdate(reserve, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, seats.get(i).getReservedRowNumber());
                ps.setInt(2, seats.get(i).getReservedSeatNumber());
                ps.setInt(3, cinemaHallId);
                ps.setInt(4, scheduleId);
                ps.setString(5, seats.get(i).getType());
            }

            @Override
            public int getBatchSize() {
                return seats.size();
            }
        });
    }
}
