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

    private Map<String,String> pics; //key为标识，value为url

    private String introduction;

    private Integer messageNum;//发送短信数量，便于统计

    private List<String> stages;//用于保存部门所有阶段名称，需排序

    private User departAdmin;//部门管理员

    public Department() {
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

    public Map<String, String> getPics() {
        return pics;
    }

    public void setPics(Map<String, String> pics) {
        this.pics = pics;
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

    public List<String> getStages() {
        return stages;
    }

    public void setStages(List<String> stages) {
        this.stages = stages;
    }

    public User getDepartAdmin() {
        return departAdmin;
    }

    public void setDepartAdmin(User departAdmin) {
        this.departAdmin = departAdmin;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", pics=" + pics +
                ", introduction='" + introduction + '\'' +
                ", messageNum=" + messageNum +
                ", stages=" + stages +
                ", departAdmin=" + departAdmin +
                '}';
    }
}
