package org.topview.entity.organization.po;

import java.io.Serializable;

/**
 * 用户实体类
 * @author Medwin。
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    //0:正在审核
    public static final Integer CHECKING = 0;
    //1:正常
    public static final Integer NORMAL = 1;
    //2:禁止
    public static final Integer FORBID = 2;

    private int id;

    private String username;

    private String password;

    private String tel;

    private String wechat;

    private int roleId;

    private int status;

    public User() {
    }

    public User(String username, String password, String tel, String wechat, int roleId, int status) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.wechat = wechat;
        this.roleId = roleId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", wechat='" + wechat + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                '}';
    }
}
