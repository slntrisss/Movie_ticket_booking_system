package org.billboard.service.dao;

import org.billboard.model.RoleDetail;
import org.billboard.repository.dao.RoleDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDetailService {
    private final RoleDetailDao roleDetailRepo;

    @Autowired
    public RoleDetailService(RoleDetailDao roleDetailDao) {
        this.roleDetailRepo = roleDetailDao;
    }

    public List<RoleDetail> getRoleDetailByDetailId(int detailId){
        return roleDetailRepo.getAllRoleDetailsByMovieId(detailId);
    }
}
