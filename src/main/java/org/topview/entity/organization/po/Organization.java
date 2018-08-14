package org.topview.entity.organization.po;

import org.topview.entity.department.po.Department;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 社团实体类
 * @author Medwin。
 */
public class Organization {
    private Integer id;

    private String name;

    private String logoUrl;

    private String tel;

    private String category;

    private String introduction;

    private String linkman; //联系人姓名

    private Integer status;           // 0 待审核,1 已通过，2 被封禁

    private String apikey;            //短信平台apikey

    private BigDecimal accountBalance;//短信平台剩余金额

    private int adminId;

    public Organization() {
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int userId) {
        this.adminId = userId;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", tel='" + tel + '\'' +
                ", category='" + category + '\'' +
                ", introduction='" + introduction + '\'' +
                ", linkman='" + linkman + '\'' +
                ", status=" + status +
                ", apikey='" + apikey + '\'' +
                ", accountBalance=" + accountBalance +
                ", adminId=" + adminId +
                '}';
    }
}
