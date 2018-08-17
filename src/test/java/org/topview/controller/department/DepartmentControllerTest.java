package org.topview.controller.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;
import org.topview.util.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class DepartmentControllerTest {

	@Autowired
	private DepartmentService departmentService;

    /**
     * 测试保存部门信息
     */
	@Test
	public void testAddDepartment() {
		Department department = new Department();
		department.setIntroduction("777");
		department.setLogoUrl("666.jpg");
		department.setOrganizationId(1);
		department.setName("安卓");
		Result result = departmentService.addDepartment(department);
		System.out.println(result.getMsg());
	}

	@Test
	public void testUpdateDepartment() {
		DepartmentBo department = new DepartmentBo();
		department.setId(1);
		department.setName("公关部");
		department.setIntroduction("啦啦啦");
		Result result = departmentService.updateDepartment(department);
		System.out.println(result.getMsg());
	}

	@Test
	public void testGetOrganizationDepartment() {
		int ogId = 1;
		Result result = departmentService.listDepartmentByOrganizationId(ogId);
		System.out.println(result.getData());
	}

	@Test
	public void testGetsigningDepartment() {
		int oid = 1;
		Result result = departmentService.getSigningDepartment(oid);
		System.out.println(result.getData());
	}
}
