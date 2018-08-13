package org.topview.entity.application;

import java.util.List;

/**
 * 报名表实体类
 * @author Medwin。
 */
public class Application {
    private int id;

    private int departmentId;

    private int organizationId;

    private String stuName;

    private String gender;

    private String academy;

    private String majorAndClass;

    private String wechat;

    private String tel;

    private String stuId;

    private String dormitory;

    private boolean adjustable; //是否允许调剂

    private String introduction;

    private List<ApplicationResult> results;//用于保存每个阶段结果

    public Application() {
    }

    public Application(int departmentId, int organizationId, String stuName, String gender, String academy, String majorAndClass,
                       String wechat, String tel, String stuId, String dormitory, boolean adjustable,
                       String introduction, List<ApplicationResult> results) {
        this.departmentId = departmentId;
        this.organizationId = organizationId;
        this.stuName = stuName;
        this.gender = gender;
        this.academy = academy;
        this.majorAndClass = majorAndClass;
        this.wechat = wechat;
        this.tel = tel;
        this.stuId = stuId;
        this.dormitory = dormitory;
        this.adjustable = adjustable;
        this.introduction = introduction;
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajorAndClass() {
        return majorAndClass;
    }

    public void setMajorAndClass(String majorAndClass) {
        this.majorAndClass = majorAndClass;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<ApplicationResult> getResults() {
        return results;
    }

    public void setResults(List<ApplicationResult> results) {
        this.results = results;
    }
}
