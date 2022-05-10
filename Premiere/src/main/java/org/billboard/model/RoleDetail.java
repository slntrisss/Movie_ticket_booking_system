package org.billboard.model;

import java.io.Serializable;

public class RoleDetail implements Serializable {
    private int roleId;
    private String roleName;
    private String roleSurname;
    private String roleType;

    public RoleDetail() {
    }

    public RoleDetail(int roleId,
                      String roleName,
                      String roleSurname,
                      String roleType) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleSurname = roleSurname;
        this.roleType = roleType;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSurname() {
        return roleSurname;
    }

    public void setRoleSurname(String roleSurname) {
        this.roleSurname = roleSurname;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
