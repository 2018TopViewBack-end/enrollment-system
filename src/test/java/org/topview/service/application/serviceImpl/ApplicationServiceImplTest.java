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
    public void add(){
        applicationResultService.addResult(1,3);
    }

    @Test
    public void addApplication() {
        Integer a = 100;

//        for (int i = 0; i < 100 ; i++){

            String stuId = "3117001";

            Application application = new Application();
            application.setDepartmentId(2);
            application.setOrganizationId(2);
            application.setStuId(stuId+a);
            application.setGender(0);
            application.setAcademy("计算机学院");
            application.setMajorAndClass("软工五班");
            application.setAdjustable(true);
            application.setDormitory("西九111");
            application.setIntroduction("test");
            application.setStuName("TEST");
            application.setTel("15521300166");
            application.setWechat("1008611780");

//            a++;
            System.out.println(applicationService.addApplication(application));
//        }
    }

    @Test
    public void listApplicationOf() {
        System.out.println(applicationService.listApplicationOf(0,50,0,3));
    }

    @Test
    public void checkApplication() {
        System.out.println(applicationService.checkApplication("3117001440",1));
    }

    @Test
    public void testtt(){
        System.out.println(applicationResultService.checkResult("15521300156","3117001440"));
    }
}