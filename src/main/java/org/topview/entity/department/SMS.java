package org.topview.entity.department;

/**
 * 短信模板实体类
 * @author Medwin。
 */
public class SMS {
    private int id;

    private int departmentId;

    private String content;//模板内容

    public SMS() {
    }

    public SMS(int departmentId, String content) {
        this.departmentId = departmentId;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
