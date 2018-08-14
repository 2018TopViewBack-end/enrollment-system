package org.topview.dao.application;

import org.topview.dao.BaseMapper;
import org.topview.entity.application.po.Application;

import java.util.List;


public interface ApplicationMapper extends BaseMapper<Application, Integer> {

    int checkApplication(String studentId, int departmentId);//检查application是否存在

    List<Application> getApplication(String tel, int studentId);
}
