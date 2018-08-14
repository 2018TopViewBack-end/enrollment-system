package org.topview.service.department.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.DepartmentMapper;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;
import org.topview.util.Constant;
import org.topview.util.Result;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	public Result updateDepartment(Department department) {
		int flag = departmentMapper.updateByExample(department);
		if (flag != 0) {
			return Result.success(department);
		}
		return Result.fail(Constant.MODIFY_DEPARTMENT_FAIL);
	}
}
