package org.topview.controller.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.service.department.SMSService;
import org.topview.util.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class SMSControllerTest {

	@Autowired
	private SMSService smsService;

	@Test
	public void testAddApiKey() {
		Result result = smsService.addApiKey(1, "ertyuidfghjkl74185296");
		System.out.println(result.getMsg());
	}
}
