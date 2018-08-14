package org.topview.service.organization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.entity.organization.po.Organization;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class OrganizationServiceImplTest {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Test
    public void testUpdateOrganization() {
        Organization organization = new Organization();
        organization.setId(1);
        organization.setApikey("apikey");
        organization.setLinkman("pan");
        /*int result = organizationMapper.updateByPrimaryKey(organization);*/
        /*System.out.println(result);*/
        System.out.println("**************");
        System.out.println(organization);
    }
}