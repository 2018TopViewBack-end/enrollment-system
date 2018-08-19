package org.topview.service.organization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.organization.po.User;

import org.topview.dao.organization.OrganizationMapper;
import org.topview.entity.organization.po.Organization;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class OrganizationServiceImplTest {

    @Test
    public void testUpdateOrganization1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        System.out.println(objectMapper.writeValueAsString(user));
    }

    @Test
    public void testUpdateOrganization2() {
        Organization organization = new Organization();
        organization.setId(1);
        organization.setApikey("apikey");
        organization.setLinkman("pan");
        /*int result = organizationMapper.updateByPrimaryKey(organization);*/
        /*System.out.println(result);*/
        System.out.println("**************");
        System.out.println(organization);

    }

    /*@Test
    public void test() {
        Result result = null;
        try {
            result = userService.updateUserStatusService(new OrganizationStatus(1,1,2));
        } catch (Exception e) {
            result = Result.fail("很抱歉，修改失败，请稍后再试");
        } finally {
            System.out.println(result.getMsg());
        }
    }*/
}