package org.topview.entity.department;

public class Stage {
    private int id;

    private int departmentId;

    private String stageName;

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

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", stageName='" + stageName + '\'' +
                '}';
    }
}
