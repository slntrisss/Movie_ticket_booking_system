package org.billboard.repository.daoMapper;

import org.billboard.model.Cinema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaNameMapper implements RowMapper<Cinema> {
    @Override
    public Cinema mapRow(ResultSet rs, int rowNum) throws SQLException {
        int cinemaId = rs.getInt("cinema_id");
        String cinemaName = rs.getString("cinema_name");

        Cinema cinema = new Cinema.CinemaBuilder()
                .setCinemaId(cinemaId)
                .setCinemaName(cinemaName)
                .build();
        return cinema;
    }
}
