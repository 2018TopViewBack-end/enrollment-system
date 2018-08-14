package org.topview.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;
import org.topview.util.Result;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping
	@ResponseBody
	public Result updateDepartment(Department department) {
		return departmentService.updateDepartment(department);
	}
}
