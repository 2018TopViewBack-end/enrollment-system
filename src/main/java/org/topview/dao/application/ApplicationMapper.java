package org.topview.dao.application;

import org.topview.dao.BaseMapper;
import org.topview.entity.application.po.Application;


public interface ApplicationMapper extends BaseMapper<Application, Integer> {

    int getId(String tel, int studentId);

    boolean checkApplication(String studentId, int departmentId);
}
