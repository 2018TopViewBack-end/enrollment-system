package org.topview.service.application;

import org.springframework.stereotype.Service;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.util.Result;

import java.util.List;

@Service
public interface ApplicationResultService {

    Result checkResult(String tel, String studentId); //查看报名结果

    Result applicationHandle(List<Integer> applicationIds, int status, int stageId);//通过或拒绝报名


}
