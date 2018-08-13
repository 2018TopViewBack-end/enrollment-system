package org.topview.entity.department.po;

import org.topview.entity.organization.po.User;

import java.util.List;
import java.util.Map;

/**
 * 部门实体类
 * @author Medwin。
 */
public class Department {
    private int id;

    private String name;

    private String logoUrl;

    private String introduction;

    private Integer messageNum;//发送短信数量，便于统计


    private Integer userId;//部门管理员id

    public Department() {
    }

    public Department(String name, String logoUrl, String introduction, Integer messageNum, Integer userId) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.introduction = introduction;
        this.messageNum = messageNum;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override

    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", introduction='" + introduction + '\'' +
                ", messageNum=" + messageNum +
                ", departAdmin=" + userId +
                '}';
    }
}
