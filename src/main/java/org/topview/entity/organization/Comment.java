package org.topview.entity.organization;

/**
 * 留言实体类
 * @author Medwin。
 */
public class Comment {
    private int id;

    private int departmentId;

    private String content;//留言内容

    private String reply;//回复内容

    public Comment() {
    }

    public Comment(int departmentId, String content, String reply) {

        this.departmentId = departmentId;
        this.content = content;
        this.reply = reply;
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
