package org.topview.service.application.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.service.application.ApplicationResultService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class ApplicationResultServiceImplTest {

    @Autowired
    ApplicationResultService applicationResultService;

    /**
     * problem
     */
    @Test
    public void checkResult() {
        System.out.println(applicationResultService.checkResult("15521300156","3117001440"));
    }

    @Test
    public void applicationHandle() {
    }
}