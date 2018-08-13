package org.topview.dao.application;

import org.topview.dao.BaseMapper;
import org.topview.entity.application.Application;


public interface ApplicationMapper extends BaseMapper<Application, Integer> {

    int getId(String tel, String studentId);

//    Application selectByDepartIdAnd
}
