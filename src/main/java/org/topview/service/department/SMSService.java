package org.topview.service.department;

import org.springframework.stereotype.Service;
import org.topview.util.Result;

import java.util.List;

@Service
public interface SMSService {

	/**
	 * 添加apiKey
	 * @param organizationId
	 * @param apiKey
	 * @return
	 */
	Result addApiKey(int organizationId, String apiKey);

	/**
	 * 获得apiKey
	 * @param organizationId
	 * @return
	 */
	Result sendMessage(int organizationId, String text, List<String> moblie);
}
