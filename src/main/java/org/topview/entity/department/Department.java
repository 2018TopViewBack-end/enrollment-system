package org.topview.entity.department;

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

    private Map<Integer,String> pics; //key为标识，value为url

    private String introduction;

    private Integer messageNum;//发送短信数量，便于统计

    private List<String> stages;//用于保存部门所有阶段名称，需排序

    public Department() {
    }

    public Department(String name, String logoUrl, Map<Integer, String> pics, String introduction, Integer messageNum, List<String> stages) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.pics = pics;
        this.introduction = introduction;
        this.messageNum = messageNum;
        this.stages = stages;
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

    public Map<Integer, String> getPics() {
        return pics;
    }

    public void setPics(Map<Integer, String> pics) {
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
}
