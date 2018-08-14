package org.topview.dao.application;

import org.topview.dao.BaseMapper;
import org.topview.entity.application.po.ApplicationResult;

import java.util.List;

public interface ApplicationResultMapper extends BaseMapper<ApplicationResult, Integer> {

    List<Integer> listSpecificAppId(int status, int stageId);

    int checkResult(int applicationId); //根据appId获取结果status

    int passApplication(int applicationId, int status);//通过报名
}
