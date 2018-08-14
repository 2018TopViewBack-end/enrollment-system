package org.topview.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;
import org.topview.util.Result;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 修改部门信息
	 * @param departmentBo
	 * @return
	 */
	@RequestMapping("/updateDepartment")
	@ResponseBody
	public Result updateDepartment(DepartmentBo departmentBo) {
		return departmentService.updateDepartment(departmentBo);
	}

	/**
	 * 新增部门
	 * @param department
	 * @return
	 */
	@RequestMapping("/addDepartment")
	@ResponseBody
	public Result addDepartment(Department department) {
		return departmentService.addDepartment(department);
	}

	/**
	 * 得到同一社团所有部门
	 * @param organizationId
	 * @return
	 */
	@RequestMapping("/getOrganizationDepartment")
	@ResponseBody
	public Result getOrganizationDepartment(int organizationId) {
		return departmentService.listDepartmentByOrganizationId(organizationId);
	}
}
