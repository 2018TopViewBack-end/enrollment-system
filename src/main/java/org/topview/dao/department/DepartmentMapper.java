package org.topview.dao.department;

import org.apache.ibatis.annotations.Param;
import org.topview.dao.BaseMapper;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.entity.department.po.SMS;
import org.topview.entity.department.vo.DepartmentVo;

import java.util.List;

/**
 *
 */
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
	 * 记录部门使用短信的数量
	 * @param id 部门id
	 * @param messageNum  发送的短信数量
	 * @return 更新成功返回1,否则返回0
	 */
	int updateDepartmentMessageNum(@Param("id") int id,@Param("messageNum") int messageNum);

	/**
	 * 修改使用短信数量前要查出以使用的短信数量
	 * @param id 部门id
	 * @return 已使用的短息数量
	 */
	int findMessageNum(int id);

	/**
	 *查询部门信息显示
	 * @param id
	 * @return 部门的相关信息
	 */
    DepartmentVo findById(int id);

}