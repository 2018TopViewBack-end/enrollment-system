package org.topview.entity.organization;

import org.topview.entity.department.Department;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 社团实体类
 * @author Medwin。
 */
public class Organization {
    private int id;

    private String name;

    private String logoUrl;

    private String tel;

    private String category;

    private String introduction;

    private String linkman; //联系人姓名

    private List<Department> departments; //社团名下部门

    private Map<Integer,String> pics; //key为标识，value为url

    private Integer status;           // 0 待审核,1 已通过，2 被封禁

    private String apikey;            //短信平台apikey

    private BigDecimal accountBalance;//短信平台剩余金额

    public Organization() {
    }

    public Organization(String name, String logoUrl, String tel, String category, String introduction, String linkman,
                        List<Department> departments, Map<Integer, String> pics, Integer status, String apikey,BigDecimal accountBalance) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.tel = tel;
        this.category = category;
        this.introduction = introduction;
        this.linkman = linkman;
        this.departments = departments;
        this.pics = pics;
        this.status = status;
        this.apikey = apikey;
        this.accountBalance = accountBalance;
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Map<Integer, String> getPics() {
        return pics;
    }

    public void setPics(Map<Integer, String> pics) {
        this.pics = pics;
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
}
