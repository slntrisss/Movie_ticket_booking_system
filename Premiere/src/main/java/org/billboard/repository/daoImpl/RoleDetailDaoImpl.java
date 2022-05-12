package org.billboard.repository.daoImpl;

import org.billboard.model.RoleDetail;
import org.billboard.repository.dao.RoleDetailDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDetailDaoImpl implements  RoleDetailDao {
    private final JdbcTemplate jdbcTemplate;
    public RoleDetailDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final String getAll = "SELECT * FROM role_detail";
    private static final String getById = "SELECT * FROM role_detail WHERE detail_id=?";


    public List<RoleDetail> getAll() {
        return jdbcTemplate.query(getAll,
                new BeanPropertyRowMapper<>(RoleDetail.class));
    }

    public void deleteById(int id) {

    }

    public void save(RoleDetail entity, int id) {

    }

    public List<RoleDetail> getAllRoleDetailsByMovieId(int id) {
        return jdbcTemplate.query(getById,
                new BeanPropertyRowMapper<>(RoleDetail.class), id);
    }
}
