package org.topview.controller.department;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.service.department.SMSService;
import org.topview.util.Result;

import java.util.List;

@Controller
@RequestMapping("/sms")
public class SMSController {

	@Autowired
	private SMSService smsService;

	/**
	 * 群发短信
	 * @param organizationId
	 * @param text
	 * @param mobile
	 * @return
	 */
	@RequestMapping("/sendMessage")
	@ResponseBody
	public Result sendMessage(@RequestParam int organizationId, @RequestParam String text, @RequestParam List<String> mobile) {
		return smsService.sendMessage(organizationId, text, mobile);
	}

	/**
	 * 添加apiKey
	 * @param organizationId
	 * @param apiKey
	 * @return
	 */
	@RequestMapping("/addApiKey")
	@ResponseBody
	public Result addApiKey(int organizationId, String apiKey) {
		return smsService.addApiKey(organizationId, apiKey);
	}
}
