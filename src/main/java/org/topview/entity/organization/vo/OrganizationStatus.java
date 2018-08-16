package org.topview.entity.organization.vo;



public class OrganizationStatus {
    private Integer organizationId;
    private Integer userId;
    // 0为待审核，1为可用，2为不可用
    private Integer status;

    public OrganizationStatus(Integer organizationId, Integer userId, Integer status) {
        this.organizationId = organizationId;
        this.userId = userId;
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}