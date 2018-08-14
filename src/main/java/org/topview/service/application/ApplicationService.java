package org.topview.service.application;

import org.springframework.stereotype.Service;
import org.topview.entity.application.po.Application;
import org.topview.util.Result;

import java.util.List;

@Service
public interface ApplicationService {

    Result addApplication(Application application);

    boolean checkApplication(String studentId , int departmentId);

    //选出特定阶段和部门的报名表
    List<Application> listApplicationOf(int status, int stageId);

    //查看是否还有上一轮未审核的报名，若有，则无法开启下一轮
    boolean checkApplicationToPass(int stageId);
}
