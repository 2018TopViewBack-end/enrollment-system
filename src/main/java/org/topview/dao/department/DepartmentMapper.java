package org.topview.dao.department;

import org.apache.ibatis.annotations.Param;
import org.topview.dao.BaseMapper;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.entity.department.vo.DepartmentVo;
import org.topview.entity.organization.po.User;

import java.util.List;

public interface DepartmentMapper extends BaseMapper<Department, Integer> {

    /**
     * 更新部门管理员
     * @param userId 部门管理员id
     * @param departmentId 部门id
     * @return 更新成功返回1,否则返回0
     */
    int updateDepartmentAdmin(@Param("userId") int userId, @Param("departmentId") int departmentId);


	/**
	 * 修改部门信息
	 * @param departmentBo
	 * @return
	 */
	int updateByExample(DepartmentBo departmentBo);

	/**
	 * 部门申请时，保存部门信息
	 * @param department
	 * @return
	 */
	@Override
	int insert(Department department);

	/**
	 * 得到同一社团所有部门
	 * @param organizationId
	 * @return
	 */
	List<DepartmentVo> listDepartmentByOrganizationId(int organizationId);

	/**
	 * 通过用户Id获得部门
	 * @param userId
	 * @return
	 */
	DepartmentVo getDepartmentByUserId(int userId);

}
