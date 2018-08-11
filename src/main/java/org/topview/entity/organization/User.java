package org.topview.entity.organization;

/**
 * 用户实体类
 * @author Medwin。
 */
public class User {
    private int id;

    private String username;

    private String password;

    private String tel;

    private String email;

    private int roleId;

    private int organizationId;

    private int departmentId;

    public User() {
    }

    public User(String username, String password, String tel, String email, int roleId, int organizationId, int departmentId) {
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.roleId = roleId;
        this.organizationId = organizationId;
        this.departmentId = departmentId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
