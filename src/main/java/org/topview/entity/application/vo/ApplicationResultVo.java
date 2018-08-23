package org.topview.entity.application.vo;

import java.util.Date;

public class ApplicationResultVo {

    private Integer id;

    private String departmentName;

    private String organizationName;

    private String stuName;

    private String stuId;

    private String gender;

    private String academy;

    private String majorAndClass;

    private String wechat;

    private String tel;

    private String dormitory;

    private boolean adjustable; //是否允许调剂

    private String stage;

    private String result;

    private Date endTime;

    @Override
    public String toString() {
        return "ApplicationResultVo{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuId='" + stuId + '\'' +
                ", gender='" + gender + '\'' +
                ", academy='" + academy + '\'' +
                ", majorAndClass='" + majorAndClass + '\'' +
                ", wechat='" + wechat + '\'' +
                ", tel='" + tel + '\'' +
                ", dormitory='" + dormitory + '\'' +
                ", adjustable=" + adjustable +
                ", stage='" + stage + '\'' +
                ", result='" + result + '\'' +
                ", endTime=" + endTime +
                '}';
    }

    public ApplicationResultVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
