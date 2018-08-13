package org.topview.service.application;

import org.springframework.stereotype.Service;
import org.topview.entity.application.po.Application;

import java.util.List;

@Service
public interface ApplicationService {

    int addApplication(Application application);

//    int deleteApplication(int id);

//    List<Application> listApplicationOfOrganization(int organizationId);

//    List<Application> listApplicationOfDepartment(int departmentId, );

    //选出特定阶段和部门的报名表
    List<Application> listApplicationOf(int departmentId, int stageId);
}
