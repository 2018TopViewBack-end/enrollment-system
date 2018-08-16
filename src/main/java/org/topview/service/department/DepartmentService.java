package org.topview.service.department;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.util.Result;

@Service
public interface DepartmentService {

	/**
	 * 修改部门信息
	 * @param departmentBo
	 * @return
	 */
	Result updateDepartment(DepartmentBo departmentBo);

	/**
	 * 新增部门
	 * @param department
	 * @return
	 */
	Result addDepartment(Department department);

	/**
	 * 得到同一社团所有部门
	 * @param organizationId
	 * @return
	 */
	Result listDepartmentByOrganizationId(int organizationId);

	/**
	 * 记录部门使用的短信数量
	 * @param id 部门id
	 * @param messageNum  部门使用的短信数量
	 * @return
	 */
	Result updateDepartmentMessageNum( int id,  int messageNum);
	/**
	 * 修改使用短信数量前要查出以使用的短信数量
	 * @param id 部门id
	 * @return 已使用的短息数量
	 */
	int findMessageNum(int id);
}
