package org.topview.service.organization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class OrganizationServiceImplTest {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Test
    public void testUpdateOrganization() throws JsonProcessingException {
//
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        System.out.println(objectMapper.writeValueAsString(user));
    }
}