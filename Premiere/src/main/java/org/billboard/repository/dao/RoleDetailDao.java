package org.billboard.repository.dao;

import org.billboard.model.RoleDetail;

import java.io.Serializable;
import java.util.List;

public interface RoleDetailDao {
    List<RoleDetail> getAllRoleDetailsByMovieId(int movieId);
    List<RoleDetail> getAll();
    void save(List<RoleDetail> roleDetails, int id);
    void deleteById(int id);
}
