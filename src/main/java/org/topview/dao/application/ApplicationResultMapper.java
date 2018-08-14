package org.topview.dao.application;

import org.topview.dao.BaseMapper;
import org.topview.entity.application.po.ApplicationResult;

import java.util.List;

public interface ApplicationResultMapper extends BaseMapper<ApplicationResult, Integer> {

    List<Integer> listSpecificAppId(int status, int stageId);

    ApplicationResult checkResult(Integer applicationId); //根据appId获取结果

    int handleApplication(int applicationId, int status);//通过报名

    int selectMaxStageId(int applicationId);
}
