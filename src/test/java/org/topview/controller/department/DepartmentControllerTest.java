package org.topview.controller.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;
import org.topview.util.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class DepartmentControllerTest {

	@Autowired
	private DepartmentService departmentService;

	@Test
	public void testUpdateDepartment() {
		Department department = new Department();
		department.setId(1);
		department.setName("公关部");
		department.setLogoUrl("666");
		department.setIntroduction("啦啦啦");
		Result result = departmentService.updateDepartment(department);
		System.out.println(result.getMsg());
	}
}
