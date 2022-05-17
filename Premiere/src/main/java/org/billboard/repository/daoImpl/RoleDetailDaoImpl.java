package org.billboard.repository.daoImpl;

import org.billboard.model.RoleDetail;
import org.billboard.repository.dao.RoleDetailDao;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoleDetailDaoImpl implements  RoleDetailDao {
    private final JdbcTemplate jdbcTemplate;
    public RoleDetailDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private static final String getAll = "SELECT * FROM role_detail";
    private static final String getById = "SELECT * FROM role_detail WHERE detail_id=?";
    private static final String saveAllRoleDetailsByDetailId =
            "INSERT INTO role_detail(ROLE_NAME, ROLE_SURNAME, ROLE_TYPE, DETAIL_ID) " +
                    "VALUES(?, ?, ?, ?)";
    private static final String deleteById = "DELETE FROM role_detail WHERE detail_id=?";


    public List<RoleDetail> getAll() {
        return jdbcTemplate.query(getAll,
                new BeanPropertyRowMapper<>(RoleDetail.class));
    }

    public void deleteById(int id) {
        jdbcTemplate.update(deleteById, id);
    }

    public void save(final List<RoleDetail> roleDetails, final int id) {
        jdbcTemplate.batchUpdate(saveAllRoleDetailsByDetailId, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, roleDetails.get(i).getRoleName());
                ps.setString(2, roleDetails.get(i).getRoleSurname());
                ps.setString(3, roleDetails.get(i).getRoleType());
                ps.setInt(4, id);
            }

            @Override
            public int getBatchSize() {
                return roleDetails.size();
            }
        });
    }

    public List<RoleDetail> getAllRoleDetailsByMovieId(int id) {
        return jdbcTemplate.query(getById,
                new BeanPropertyRowMapper<>(RoleDetail.class), id);
    }
}
