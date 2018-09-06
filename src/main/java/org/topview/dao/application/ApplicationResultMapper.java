package org.topview.dao.application;

import org.springframework.stereotype.Repository;
import org.topview.dao.BaseMapper;
import org.topview.entity.application.po.Application;
import org.topview.entity.application.po.ApplicationResult;

import java.util.List;

@Repository
public interface ApplicationResultMapper extends BaseMapper<ApplicationResult, Integer> {

    List<Integer> listSpecificApplicationId(int status, int stageId);

    ApplicationResult checkResult(Integer applicationId); //根据appId获取结果

    int handleApplication(int applicationId, int status, int stageId, String datetime);//通过报名

    int addResult(Integer applicationId, Integer stageId);//为报名表添加结果

    List<Application> listSpecificApplication(Integer status, Integer stageId);
}
