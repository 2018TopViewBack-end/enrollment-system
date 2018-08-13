package org.topview.service.application.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.application.ApplicationMapper;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.entity.application.po.Application;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.service.application.ApplicationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationResultMapper applicationResultMapper;

    @Override
    public int addApplication(Application application) {
        return 0;
    }

    @Override
    public List<Application> listApplicationOf(int departmentId, int stageId) {
//        //取得特定阶段报名结果
////        List<ApplicationResult> results = applicationResultMapper.listAppResultByStage(stageId);
////        List<Integer> applicationIds = new ArrayList<>();
////        List<Application> applications = new ArrayList<>();
////        //取得该阶段报名表
////        for (ApplicationResult result : results){
////            applicationIds.add(result.getApplicationId());
////        }
////
////        for(Integer applicationId : applicationIds){
////            applications.add(applicationMapper.selectByPrimaryKey(applicationId));
////        }
        return null;
    }
}
