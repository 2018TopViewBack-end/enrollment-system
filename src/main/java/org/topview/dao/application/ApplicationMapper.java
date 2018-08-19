package org.topview.dao.application;

import org.springframework.stereotype.Repository;
import org.topview.dao.BaseMapper;
import org.topview.entity.application.po.Application;

import java.util.List;


@Repository
public interface ApplicationMapper extends BaseMapper<Application, Integer> {

    Integer checkApplication(String studentId, int departmentId);//检查application是否存在

    List<Application> getApplication(String tel, String studentId);
}
