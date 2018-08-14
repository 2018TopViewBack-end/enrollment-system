package org.topview.service.application.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.application.ApplicationMapper;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.entity.application.po.Application;
import org.topview.service.application.ApplicationService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationResultMapper applicationResultMapper;

    @Override
    public Result addApplication(Application application) {
        if (checkApplication(application.getStuId(),application.getDepartmentId())){
            //若存在,则注册失败
            return Result.fail(Constant.SUBMIT_FAILED);
        } else {
            return Result.success(Constant.SUBMIT_SUCCEED);
        }
    }

    @Override
    public List<Application> listApplicationOf(int status, int stageId) {
        //取得特定阶段报名结果
        List<Integer> applicationIds = applicationResultMapper.listSpecificAppId(status, stageId);
        List<Application> applications = new ArrayList<>();

        for(Integer applicationId : applicationIds){
            applications.add(applicationMapper.selectByPrimaryKey(applicationId));
        }
        return applications;
    }

    @Override
    public boolean checkApplication(String studentId, int departmentId) {
        if (0 == applicationMapper.checkApplication(studentId, departmentId)){
            return true;
        } else {
            return false;
        }
    }
//
//    @Override
//    public boolean checkApplicationToPass(int stageId) {
//        List<Application> applications = listApplicationOf(0, stageId);
//        if (null == applications){
//            //若还有未审核报名，返回true
//            return true;
//        } else {
//            return false;
//        }
//    }
}
