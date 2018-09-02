package org.topview.service.department;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.dao.department.SMSMapper;
import org.topview.util.MessageUtil;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class SMSServiceImplTest {

	@Autowired
	private SMSMapper smsMapper;

	@Test
	public void testAddApiKey() {
		int oid = 1;
		String apiKey = "ertyguhllvbjnkml7542";
		System.out.println(smsMapper.addApiKey(oid, apiKey));
	}

	@Test
	public void testSend() {
		int orgId = 1;
		String text = "【邓哲睿】清林同学你好，恭喜你通过了我们的一面，请于8月20到教一参加二面";
		List<String> mobile = new ArrayList<String>();
		mobile.add("15521079814");
		String apiKey = smsMapper.getApiKey(orgId);
		String rt = MessageUtil.send(text, mobile, apiKey);
		JSONObject jo = new JSONObject(rt);
		System.out.println(jo);
	}
}
