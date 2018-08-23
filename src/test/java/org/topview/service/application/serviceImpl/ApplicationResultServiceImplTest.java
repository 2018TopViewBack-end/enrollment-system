package org.topview.service.application.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.dao.application.ApplicationMapper;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.service.application.ApplicationResultService;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class ApplicationResultServiceImplTest {

    @Autowired
    ApplicationResultService applicationResultService;

    @Autowired
    ApplicationResultMapper applicationResultMapper;

    /**
     * problem
     */
    @Test
    public void checkResult() {
        System.out.println(applicationResultService.checkResult("15521300157","3117001120"));
    }

    @Test
    public void applicationHandle() {
        List<Integer> appids = new ArrayList<>();
        appids.add(3);
        appids.add(4);
        applicationResultService.applicationHandle(appids,1,3);
    }

    @Test
    public void search(){
        System.out.println(applicationResultService.searchResult("3117001440",1,2));
    }

    @Test
    public void handle(){
        int id = 3;
        int status = 1;
        int stageId = 3;
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        applicationResultMapper.handleApplication(id, status, stageId, currentTime);
    }
}