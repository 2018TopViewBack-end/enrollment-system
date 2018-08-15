package org.topview.dao.department;

import org.topview.dao.BaseMapper;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.entity.department.vo.DepartmentVo;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department, Integer> {

	/**
	 * 修改部门信息
	 * @param departmentBo
	 * @return
	 */
	int updateByExample(DepartmentBo departmentBo);

	/**
	 * 新增部门
	 * @param department
	 * @return
	 */
	int insert(Department department);

	/**
	 * 得到同一社团所有部门
	 * @param organizationId
	 * @return
	 */
	List<DepartmentVo> listDepartmentByOrganizationId(int organizationId);

    /**
     * 部门申请时，保存部门信息
     * @param department
     */
    void saveDepartment(Department department);
}
