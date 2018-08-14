package org.topview.dao.department;

import org.springframework.stereotype.Repository;
import org.topview.entity.department.po.Department;
@Repository
public interface DepartmentMapper  {
    //部门申请时，保存部门信息
    void saveDepartment(Department department);
}
