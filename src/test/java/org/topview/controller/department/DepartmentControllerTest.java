package org.topview.controller.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class DepartmentControllerTest {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 测试保存部门信息
     */
    @Test
    public void saveDepartment() {
        Department department = new Department(1,"jdf","fsd","dfjsk",2,2);
        departmentService.saveDepartment(department);
    }
}