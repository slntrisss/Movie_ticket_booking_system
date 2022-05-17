package org.billboard.repository.dao;

import org.billboard.model.Booking;

public interface BookingDao {
    void reserve(Booking booking, int userId, int scheduleId);
}
