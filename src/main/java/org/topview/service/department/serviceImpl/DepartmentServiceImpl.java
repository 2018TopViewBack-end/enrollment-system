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
				return Result.success();
			}
			return Result.fail(Constant.MODIFY_DEPARTMENT_FAIL);
	}

	@Override
	public Result addDepartment(Department department) {
			int flag = departmentMapper.insert(department);
			if (flag != 0) {
				return Result.success(department);
			}
			return Result.fail(Constant.ADD_DEPARTMENT_FAIL);
	}

	@Override
	public Result listDepartmentByOrganizationId ( int organizationId){
		List<DepartmentVo> departments = departmentMapper.listDepartmentByOrganizationId(organizationId);
		if (departments.size() != 0) {
			return Result.success(departments);
		}
		return Result.fail(Constant.EMPTY_DEPARTMENT);
	}

	@Override
	public Result updateDepartmentMessageNum(int id, int messageNum) {
		int oldMessageNum = findMessageNum(id);
		int newMessageNum = oldMessageNum + messageNum;
		int flog = departmentMapper.updateDepartmentMessageNum(id,newMessageNum);
		if (flog == 1){
			return Result.success("已使用了"+newMessageNum+"条短信");
		}else {
			return Result.fail("修改失败");
		}
	}

	@Override
	public int findMessageNum(int id) {
		return departmentMapper.findMessageNum(id);

	}

	@Override
	public Result findById(int id) {
		DepartmentVo departmentInfoVo = departmentMapper.findById(id);
		return Result.success(departmentInfoVo);
	}
}