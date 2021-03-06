package org.topview.service.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.department.StageMapper;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.entity.department.vo.DepartmentVo;

import java.util.Iterator;
import java.util.List;
import org.topview.service.department.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class DepartmentServiceImplTest {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private StageMapper stageMapper;

	@Test
	public void testUpdateDepartment() {
		DepartmentBo department = new DepartmentBo();
		department.setId(1);
		department.setName("公关部");
		department.setIntroduction("略略略");
		int flag = departmentMapper.updateByExample(department);
		System.out.println(flag);
	}

	@Test
	public void testAddDepartment() {
		Department department = new Department();
		department.setIntroduction("777");
		department.setLogoUrl("666.jpg");
		department.setOrganizationId(1);
		department.setName("前端");
		int flag = departmentMapper.insert(department);
		System.out.println(flag);
	}

	@Test
	public void testListDepartmentByOrganizationId() {
		int ogId = 1;
		List<DepartmentVo> departments = departmentMapper.listDepartmentByOrganizationId(ogId);
		for (DepartmentVo department : departments){
			System.out.println(department);
		}
	}

	/**
	 * 测试：获得没有结束报名的状态
	 */
	@Test
	public void testGetSigningDepartment() {
		int oid = 1;
		List<DepartmentVo> departmentVos = departmentMapper.listDepartmentByOrganizationId(oid);
		if (null != departmentVos && departmentVos.size() > 0) {
			Iterator it = departmentVos.iterator();
			while(it.hasNext()){
				DepartmentVo departmentVo = (DepartmentVo)it.next();
				if (stageMapper.selectByExample(departmentVo.getId()).size() != 0) {
					it.remove();
				}
			}
		}
		System.out.println(departmentVos);
	}
}
