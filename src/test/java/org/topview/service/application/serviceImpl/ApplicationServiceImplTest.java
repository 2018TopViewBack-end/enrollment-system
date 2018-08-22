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
        application.setStuId("3117001441");
        application.setGender(0);
        application.setAcademy("自动化学院");
        application.setMajorAndClass("物联网五班");
        application.setAdjustable(true);
        application.setDormitory("西九512");
        application.setIntroduction("a good person");
        application.setStuName("MMM");
        application.setTel("15521300166");
        application.setWechat("1008611780");
        System.out.println(applicationService.addApplication(application));
    }

    @Test
    public void listApplicationOf() {
        System.out.println(applicationService.listApplicationOf(0,2,1,2));
    }

    @Test
    public void checkApplication() {
        System.out.println(applicationService.checkApplication("3117001440",1));
    }
}