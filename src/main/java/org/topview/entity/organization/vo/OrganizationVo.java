package org.topview.entity.organization.vo;

import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;

public class OrganizationVo {
    private User user;

    private Organization organization;

    private String vCode;

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public OrganizationVo() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "OrganizationVo{" +
                "user=" + user +
                ", organization=" + organization +
                ", vCode='" + vCode + '\'' +
                '}';
    }
}
