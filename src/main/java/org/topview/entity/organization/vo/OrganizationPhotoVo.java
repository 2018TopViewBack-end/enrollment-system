package org.topview.entity.organization.vo;

/**
 * @author Pan梓涵
 * 首页社团图片展示
 */
public class OrganizationPhotoVo {

    /**
    * 社团类别
    */
    private String category;

    /**
     * 社团名字
     */
    private String name;

    /**
    * 图片的url
    */
    private String logoUrl;

    public OrganizationPhotoVo() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
