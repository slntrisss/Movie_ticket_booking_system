package org.billboard.repository.daoMapper;

import org.billboard.model.Cinema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaDaoMapper implements RowMapper<Cinema> {
    @Override
    public Cinema mapRow(ResultSet rs, int rowNum) throws SQLException {
        int cinemaId = rs.getInt("cinema_id");
        String cinemaName = rs.getString("cinema_name");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        String imageFile = rs.getString("image_file");
        return new Cinema.CinemaBuilder()
                .setCinemaId(cinemaId)
                .setCinemaName(cinemaName)
                .setAddress(address)
                .setPhone(phone)
                .setImageFile(imageFile)
                .build();
    }
}
