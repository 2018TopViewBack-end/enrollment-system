package org.topview.service.organization;

import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.config.exception.RegisterFailException;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.util.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Test
    public void registerTest(){
        User user = new User();
        user.setTel("123412");
        user.setUsername("aaa123");
        user.setPassword("aaaa");

        Organization organization = new Organization();
        organization.setName("ooo");
        try {
            Result result = userService.register(user, organization);
                    System.out.println(result.getMsg());
        } catch (RegisterFailException e) {
            e.printStackTrace();
        }
    }
}
