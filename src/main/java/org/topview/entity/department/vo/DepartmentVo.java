package org.topview.entity.department.vo;

import org.topview.entity.organization.po.User;

import java.util.Map;

public class DepartmentVo {

    private String departmentName;

    private String organizationName;

    private String introduction;

    private Map<String, String> pics;//key为图片标识，value为url

    private Integer messageNum;//发送短信数量，便于统计

    private User user;//部门管理员

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, String> getPics() {
        return pics;
    }

    public void setPics(Map<String, String> pics) {
        this.pics = pics;
    }
}
