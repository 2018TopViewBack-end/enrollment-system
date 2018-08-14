package org.topview.service.application;

import org.springframework.stereotype.Service;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.util.Result;

import java.util.List;

@Service
public interface ApplicationResultService {

    Result checkResult(String tel, int studentId); //查看报名状态

    void applicationHandle(List<Integer> applicationIds, int status);//通过或拒绝报名


}
