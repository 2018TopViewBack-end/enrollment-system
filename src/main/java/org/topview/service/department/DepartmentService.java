package org.topview.service.department;

import org.springframework.stereotype.Service;
import org.topview.entity.department.po.Department;
import org.topview.util.Result;

@Service
public interface DepartmentService {

	/**
	 * 修改部门信息
	 * @param department
	 * @return
	 */
	Result updateDepartment(Department department);
}
