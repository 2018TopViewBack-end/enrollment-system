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
import java.util.List;

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

    /**
     * 取得特定阶段和状态的报名结果并分页
     * @param pageNum
     * @param pageSize
     * @param status
     * @param stageId
     * @return
     */
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

    /**
     * 检查报名表是否重复提交
     * @param studentId
     * @param departmentId
     * @return
     */
    @Override
    public boolean checkApplication(String studentId, int departmentId) {
        if (null == applicationMapper.checkApplication(studentId, departmentId)){
            return false;
        }
        return true;
    }

    /**
     * 分页列出部门所有报名表
     * @param pageNum
     * @param pageSize
     * @param departmentId
     * @return
     */
    @Override
    public PageInfo<Application> listAll(int pageNum, int pageSize, Integer departmentId) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(listAll(departmentId));
    }

    @Override
    public List<Application> listAll(Integer departmentId) {
        //取得特定部门报名结果
        List<Application> applications = applicationMapper.listAllOfDepartment(departmentId);
        return applications;
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
