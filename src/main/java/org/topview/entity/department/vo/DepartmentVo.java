package org.topview.entity.department.vo;

import org.topview.entity.organization.po.User;

public class DepartmentVo {

	private String name;

	private String logoUrl;

	private String introduction;

	private Integer messageNum;//发送短信数量，便于统计

	private User user;//部门管理员

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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(Integer messageNum) {
		this.messageNum = messageNum;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DepartmentVo{" +
				"name='" + name + '\'' +
				", logoUrl='" + logoUrl + '\'' +
				", introduction='" + introduction + '\'' +
				", messageNum=" + messageNum +
				", user=" + user +
				'}';
	}
}
