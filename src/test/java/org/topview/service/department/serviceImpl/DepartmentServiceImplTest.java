package org.topview.service.department.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class DepartmentServiceImplTest {
    @Autowired
    private DepartmentService departmentService;
    @Test
    public void saveDepartment() {
        /*Department department = new Department(1,"dsfs","dfsa","fdsakl",12,1);
        departmentService.saveDepartment(department);
        System.out.println(department);*/
    }
}