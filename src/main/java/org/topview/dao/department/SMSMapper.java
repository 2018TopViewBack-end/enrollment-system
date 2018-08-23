package org.topview.dao.department;

import org.topview.dao.BaseMapper;
import org.topview.entity.department.po.SMS;

public interface SMSMapper extends BaseMapper<SMS, Integer> {
	/**
	 * 添加APIKEY
	 * @return
	 */
	int addApiKey(int organizationId, String apiKey);

	/**
	 * 获得apiKey
	 */
	String getApiKey(int organizationId);
}
