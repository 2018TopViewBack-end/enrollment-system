package org.topview.service.department.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.DepartmentMapper;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.entity.department.vo.DepartmentVo;
import org.topview.service.department.DepartmentService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	public Result updateDepartment(DepartmentBo departmentBo) {
		int flag = departmentMapper.updateByExample(departmentBo);
		if (flag != 0) {
			return Result.success(departmentBo);
		}
		return Result.fail(Constant.MODIFY_DEPARTMENT_FAIL);
	}

	@Override
	public Result addDepartment(Department department) {
		int flag = departmentMapper.insert(department);
		if (flag != 0) {
			return Result.success();
		}
		return Result.fail(Constant.ADD_DEPARTMENT_FAIL);
	}

	@Override
	public Result listDepartmentByOrganizationId(int organizationId) {
		List<DepartmentVo> departments = departmentMapper.listDepartmentByOrganizationId(organizationId);
		if (departments.size() != 0) {
			return Result.success(departments);
		}
		return Result.fail(Constant.EMPTY_DEPARTMENT);
	}
}
