package org.billboard.repository.daoImpl;

import org.billboard.model.TicketType;
import org.billboard.repository.dao.TicketTypeDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TicketTypeDaoImpl implements TicketTypeDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getTickets = "SELECT * FROM ticket_type WHERE schedule_id=?";

    public TicketTypeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TicketType getTicket(int id) {
        return jdbcTemplate.queryForObject(getTickets,
                new BeanPropertyRowMapper<>(TicketType.class), id);
    }
}
