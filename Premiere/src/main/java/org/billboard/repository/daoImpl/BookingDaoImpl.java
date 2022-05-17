package org.billboard.repository.daoImpl;

import org.billboard.model.Booking;
import org.billboard.repository.dao.BookingDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDaoImpl implements BookingDao {
    private final JdbcTemplate jdbcTemplate;

    private static final String reserve =
            "insert into booking(payment_date, price, user_id, schedule_id) " +
            "values (?, ?, ?, ?)";
    public BookingDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void reserve(Booking booking, int userId, int scheduleId) {
        jdbcTemplate.update(reserve, booking.getPaymentDate(),
                booking.getPrice(), userId, scheduleId);
    }
}
