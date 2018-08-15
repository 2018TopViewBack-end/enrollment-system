package org.topview.service.department;

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
     * 部门报名时保存部门的信息
     * @param department
     */
    void saveDepartment(Department department);
}
