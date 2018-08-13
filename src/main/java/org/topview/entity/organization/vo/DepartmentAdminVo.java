package org.topview.entity.organization.vo;

import org.topview.entity.organization.po.User;

public class DepartmentAdminVo {

    private Integer departmentId;
    private User user;

    public DepartmentAdminVo() {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DepartmentAdminVo{" +
                "departmentId=" + departmentId +
                ", user=" + user +
                '}';
    }
}
