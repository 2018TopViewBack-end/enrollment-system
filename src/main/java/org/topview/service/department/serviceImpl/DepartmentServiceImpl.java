package org.topview.service.department.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.DepartmentMapper;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    //部门申请时，保存部门信息
    @Override
    public void saveDepartment(Department department) {
         departmentMapper.saveDepartment(department);
    }
}
