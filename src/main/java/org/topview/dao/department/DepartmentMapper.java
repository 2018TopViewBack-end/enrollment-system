package org.topview.dao.department;

import org.apache.ibatis.annotations.Param;
import org.topview.dao.BaseMapper;
import org.topview.entity.department.po.Department;

public interface DepartmentMapper extends BaseMapper<Department, Integer> {

    /**
     * 更新部门管理员
     * @param userId 部门管理员id
     * @param departmentId 部门id
     * @return 更新成功返回1,否则返回0
     */
    int updateDepartmentAdmin(@Param("userId") int userId, @Param("departmentId") int departmentId);

}
