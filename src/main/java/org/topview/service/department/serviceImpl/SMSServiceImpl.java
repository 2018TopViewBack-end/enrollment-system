package org.topview.service.department.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.SMSMapper;
import org.topview.service.department.SMSService;
import org.topview.util.MessageUtil;
import org.topview.util.Result;

import java.util.List;

@Service
public class SMSServiceImpl implements SMSService {

	@Autowired
	private SMSMapper smsMapper;

	@Override
	public Result addApiKey(int organizationId, String apiKey) {
		int flag = smsMapper.addApiKey(organizationId, apiKey);
		if (flag == 1) {
			return Result.success(apiKey);
		}
		return Result.fail("添加apiKey失败");
	}

	@Override
	public Result sendMessage(int organizationId, String text, List<String> mobile) {
		String apiKey = smsMapper.getApiKey(organizationId);
		if (apiKey != null) {
			String responseText = MessageUtil.send(text, mobile, apiKey);
			return Result.success(responseText);
		}
		return Result.fail("没有apiKey");
	}
}
