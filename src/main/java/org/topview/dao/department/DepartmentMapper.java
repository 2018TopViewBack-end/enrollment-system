package org.topview.dao.department;

import org.topview.dao.BaseMapper;
import org.topview.entity.department.po.Department;

public interface DepartmentMapper extends BaseMapper<Department, Integer> {

	/**
	 * 修改部门信息
	 * @param department
	 * @return
	 */
	int updateByExample(Department department);
}
