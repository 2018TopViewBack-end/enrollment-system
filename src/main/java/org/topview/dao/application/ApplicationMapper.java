package org.topview.dao.application;

import org.topview.dao.BaseMapper;
<<<<<<< HEAD
import org.topview.entity.application.po.Application;
=======
import org.topview.entity.application.Application;

>>>>>>> f7f7944742ab4dff3dc53dfeb83a0d2f86da1856

public interface ApplicationMapper extends BaseMapper<Application, Integer> {

    int getId(String tel, String studentId);
}
