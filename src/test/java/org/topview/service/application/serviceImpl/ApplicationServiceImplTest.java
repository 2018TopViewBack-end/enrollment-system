package org.topview.service.application.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.application.po.Application;
import org.topview.service.application.ApplicationResultService;
import org.topview.service.application.ApplicationService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class ApplicationServiceImplTest {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    ApplicationResultService applicationResultService;

    @Test
    public void addApplication() {
        Application application = new Application();
        application.setDepartmentId(1);
        application.setOrganizationId(1);
        application.setStuId("3117001440");
        application.setGender("male");
        application.setAcademy("自动化");
        application.setMajorAndClass("物联网五班");
        application.setAdjustable(true);
        application.setDormitory("西九512");
        application.setIntroduction("a real good person");
        application.setStuName("Maven");
        application.setTel("15521300156");
        application.setWechat("1008611789");
        applicationService.addApplication(application);
    }

    @Test
    public void listApplicationOf() {
        applicationService.listApplicationOf(0,1);
    }

    @Test
    public void checkApplication() {
        applicationService.checkApplication("3117001440",1);
    }
}