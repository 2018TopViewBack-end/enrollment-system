package org.topview.service.department;

import org.springframework.stereotype.Service;
import org.topview.entity.department.po.Department;

@Service
public interface DepartmentService {
    //部门申请时保存部门信息
    void saveDepartment(Department department);
}
