package org.topview.service.application;

import org.springframework.stereotype.Service;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.util.Result;

import java.util.List;

@Service
public interface ApplicationResultService {

    Result checkResult(String tel, String studentId); //查看报名结果

    Result applicationHandle(List<Integer> applicationIds, int status, int stageId);//批量通过或拒绝报名

    Result searchResult(String condition, int status, int stageId);//根据姓名或学号搜索结果
}
