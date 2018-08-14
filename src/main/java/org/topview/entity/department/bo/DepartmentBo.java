package org.topview.entity.department.bo;

import java.util.Map;

/**
 * 部门可以修改的字段
 */
public class DepartmentBo {
    private int id;

    private String name;

    private Map<String, String> pics;//key为图片标识，value为url

    private String introduction;

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
}
