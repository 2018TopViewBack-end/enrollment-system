package org.topview.controller.administrator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.bo.SlideshowBo;
import org.topview.entity.organization.vo.CheckPassword;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.OrganizationService;
import org.topview.service.organization.SlideshowService;
import org.topview.service.organization.UserService;
import org.topview.util.Result;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class UserTest {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserService userService;

    @Test
    public void updateUserStatusTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        OrganizationStatus os = new OrganizationStatus(1,1,1);
        CheckPassword checkPassword = new CheckPassword();
        System.out.println(objectMapper.writeValueAsString(Result.success()));
    }

    @Test
    public void test() throws JsonProcessingException {
        /*List resultList= organizationService.selectOrganizationService(2);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(Result.success(PageInfo.of(resultList))));
        List<SlideshowBo> slideshowList = slideshowService.selectSlideShowService();
        System.out.println(objectMapper.writeValueAsString(Result.fail("很抱歉，修改失败，请稍后再试")));*/

        OrganizationStatus organizationStatus = new OrganizationStatus(2,2,1);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(organizationStatus));
        /*String apiKey = "emmm";
        try {
            userService.updateUserStatusService(organizationStatus,apiKey);
        } catch (Exception e) {
            System.out.println("GG");
        }*/
    }
}
