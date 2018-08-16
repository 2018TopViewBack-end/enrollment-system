package org.topview.entity.department.po;

public class organization_photo {
    private Integer organization_id;
    private Integer department_id;
    private String photoUrl;
    private String phoneTag;

    public organization_photo() {
    }

    public organization_photo(Integer organization_id, Integer department_id, String photoUrl, String phoneTag) {
        this.organization_id = organization_id;
        this.department_id = department_id;
        this.photoUrl = photoUrl;
        this.phoneTag = phoneTag;
    }

    public Integer getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Integer organization_id) {
        this.organization_id = organization_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhoneTag() {
        return phoneTag;
    }

    public void setPhoneTag(String phoneTag) {
        this.phoneTag = phoneTag;
    }

    @Override
    public String toString() {
        return "organization_photo{" +
                "organization_id=" + organization_id +
                ", department_id=" + department_id +
                ", photoUrl='" + photoUrl + '\'' +
                ", phoneTag='" + phoneTag + '\'' +
                '}';
    }
}
