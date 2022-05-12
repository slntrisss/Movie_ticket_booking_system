package org.billboard.repository.daoMapper;

import org.billboard.model.Cinema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaDetailMapper implements RowMapper<Cinema> {
    @Override
    public Cinema mapRow(ResultSet rs, int rowNum) throws SQLException {
        int cinemaId = rs.getInt("cinema_id");
        String cinemaName = rs.getString("cinema_name");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        String info = rs.getString("info");
        String startOfWork = rs.getString("start_of_work");
        String endOfWork = rs.getString("end_of_work");
        String imageFile = rs.getString("image_file");

        Cinema cinema = new Cinema.CinemaBuilder()
                .setCinemaId(cinemaId)
                .setCinemaName(cinemaName)
                .setAddress(address)
                .setPhone(phone)
                .setInfo(info)
                .setStartOfWork(startOfWork)
                .setEndOfWork(endOfWork)
                .setImageFile(imageFile)
                .build();
        return cinema;
    }
}
