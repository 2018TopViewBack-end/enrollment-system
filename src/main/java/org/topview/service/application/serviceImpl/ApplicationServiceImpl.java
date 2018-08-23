package org.topview.service.application.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

/**
 * 报名表service
 * @author Medwin。
 */
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
            applicationMapper.insert(application);
            return Result.success();
        }
    }

    @Override
    public PageInfo<Application> listApplicationOf(int pageNum, int pageSize, int status, int stageId) {
        PageHelper.startPage(pageNum, pageSize);

        //取得特定阶段报名结果
        List<Integer> applicationIds = applicationResultMapper.listSpecificApplicationId(status, stageId);
        List<Application> applications = new ArrayList<>();
        for(Integer applicationId : applicationIds){
            applications.add(applicationMapper.selectByPrimaryKey(applicationId));
        }

        PageInfo<Application> applicationPageInfo = new PageInfo<>(applications);
        return applicationPageInfo;
    }

    @Override
    public boolean checkApplication(String studentId, int departmentId) {
        if (null == applicationMapper.checkApplication(studentId, departmentId)){
            return false;
        }
        return true;
    }

    @Override
    public PageInfo<Application> listAll(int pageNum, int pageSize, Integer departmentId) {
        PageHelper.startPage(pageNum, pageSize);

        //取得特定部门报名结果
        List<Application> applications = applicationMapper.listAllOfDepartment(departmentId);
        return new PageInfo<>(applications);
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
