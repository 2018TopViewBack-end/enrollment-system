package org.topview.entity.department.po;

/**
 * 部门实体类
 * @author Medwin。
 */
public class Department {
    private int id;

    private int organizationId;

    private String name;

    private String logoUrl;

    private String introduction;

    /**
     * 发送短信数量,便于统计
     */
    private Integer messageNum;

    /**
     * 部门管理员id
     */
    private int userId;

    public Department() {
    }

    public Department(int organizationId, String name, String logoUrl, String introduction, Integer messageNum, int userId) {
        this.organizationId = organizationId;
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

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", introduction='" + introduction + '\'' +
                ", messageNum=" + messageNum +
                ", userId=" + userId +
                '}';
    }
}
