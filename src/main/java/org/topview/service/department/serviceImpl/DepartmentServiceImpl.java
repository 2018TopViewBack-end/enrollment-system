package org.topview.service.department.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.department.StageMapper;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.entity.department.po.SMS;
import org.topview.entity.department.vo.DepartmentVo;
import org.topview.service.department.DepartmentService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.Iterator;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private StageMapper stageMapper;

	/**
	 * 修改部门
	 * @param departmentBo
	 * @return
	 */
	public Result updateDepartment(DepartmentBo departmentBo) {
			int flag = departmentMapper.updateByExample(departmentBo);
			if (flag != 0) {
				return Result.success();
			}
			return Result.fail(Constant.MODIFY_DEPARTMENT_FAIL);
	}

	/**
	 * 增加部门
	 * @param department
	 * @return
	 */
	@Override
	public Result addDepartment(Department department) {
			int flag = departmentMapper.insert(department);
			if (flag != 0) {
				return Result.success(department);
			}
			return Result.fail(Constant.ADD_DEPARTMENT_FAIL);
	}

	/**
	 * 获得社团所有部门
	 * @param organizationId
	 * @return
	 */
	@Override
	public Result listDepartmentByOrganizationId ( int organizationId){
		List<DepartmentVo> departments = departmentMapper.listDepartmentByOrganizationId(organizationId);
		if (departments.size() != 0) {
			return Result.success(departments);
		}
		return Result.fail(Constant.EMPTY_DEPARTMENT);
	}

	/**
	 * 获得没有阶段的部门
	 * @return
	 */
	@Override
	public Result getSigningDepartment(int organizationId) {
		List<DepartmentVo> departmentVos = departmentMapper.listDepartmentByOrganizationId(organizationId);
		if (null != departmentVos && departmentVos.size() > 0) {
			Iterator it = departmentVos.iterator();
			while(it.hasNext()){
				DepartmentVo departmentVo = (DepartmentVo)it.next();
				if (stageMapper.selectByExample(departmentVo.getId()).size() != 0) {
					it.remove();
				}
			}
		}
		return Result.success(departmentVos);
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