package org.topview.entity.department.po;

public class Stage {

    private int id;

    private int departmentId;

    private String stageName;

    private int status;

    public Stage() {
    }

    public Stage(int departmentId, String stageName) {
        this.departmentId = departmentId;
        this.stageName = stageName;
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

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", stageName='" + stageName + '\'' +
                ", status=" + status +
                '}';
    }
}
