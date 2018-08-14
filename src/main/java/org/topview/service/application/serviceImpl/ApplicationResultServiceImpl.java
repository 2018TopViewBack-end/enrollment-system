package org.topview.service.application.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.application.ApplicationMapper;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.service.application.ApplicationResultService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class ApplicationResultServiceImpl implements ApplicationResultService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationResultMapper applicationResultMapper;

    @Override
    public Result checkResult(String tel, int studentId) {
        //getAppId
        int applicationId = applicationMapper.getId(tel, studentId);

        //getResult
        int result = applicationResultMapper.checkResult(applicationId);
        Map<String, Object> map = new HashMap<>();

        if(0 == result){
            map.put("result",Constant.TO_BE_DECIDED);
        } else if(1 == result){
            map.put("result",Constant.PASSED);
        } else if (2 == result){
            map.put("result",Constant.DID_NOT_PASS);
        } else {
            map.put("result",Constant.INFO_NOT_FOUND);
        }
        return Result.success(map);
    }

    @Override
    public void applicationHandle(List<Integer> applicationIds, int status) {
        for (int id : applicationIds){
            applicationResultMapper.passApplication(id,status);
        }
    }
}
