package org.topview.service.application.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.application.ApplicationMapper;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.department.StageMapper;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.entity.application.po.Application;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.entity.application.vo.ApplicationResultVo;
import org.topview.service.application.ApplicationResultService;
import org.topview.service.application.ApplicationService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 报名表结果service
 * @author Medwin。
 */
@Service
public class ApplicationResultServiceImpl implements ApplicationResultService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationResultMapper applicationResultMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private StageMapper stageMapper;

    @Autowired
    private ApplicationService applicationService;

    /**
     * 查看报名结果
     * @param tel
     * @param studentId
     * @return Result
     */
    @Override
    public Result checkResult(String tel, String studentId) {
        //取得该学生所有申请
        List<Application> applications = applicationMapper.getApplication(tel, studentId);

        List<ApplicationResultVo> results = setProperties(applications);
        return Result.success(results);
    }

    /**
     * 设置ApplicationResultVo字段值
     * @param applications
     * @return
     */
    private List<ApplicationResultVo> setProperties(List<Application> applications){
        List<ApplicationResultVo> results = new ArrayList<>();

        for (Application application: applications){
            //遍历该学生每一张报名表
//            int departmentId = application.getDepartmentId();
            //获取stageid最大的result
            ApplicationResult applicationResult = applicationResultMapper.checkResult(application.getId());

            ApplicationResultVo applicationResultVo= new ApplicationResultVo();
            //复制和设置vo字段值
            BeanUtils.copyProperties(application,applicationResultVo);
            if (null != applicationResult){
                BeanUtils.copyProperties(applicationResult,applicationResultVo);
                String stageName = stageMapper.selectByPrimaryKey(applicationResult.getStageId()).getStageName();
                applicationResultVo.setStage(stageName);

                if (0 == applicationResult.getStatus()){
                    applicationResultVo.setResult(Constant.TO_BE_DECIDED);
                } else if (1 == applicationResult.getStatus()){
                    applicationResultVo.setResult(Constant.PASSED);
                } else {
                    applicationResultVo.setResult(Constant.DID_NOT_PASS);
                }
            } else {
                //若没有结果信息
                applicationResultVo.setStage(Constant.NO_INFO);
                applicationResultVo.setResult(Constant.NO_INFO);
            }

            String organizationName = organizationMapper.selectByPrimaryKey(application.getOrganizationId()).getName();
            String departmentName = departmentMapper.selectByPrimaryKey(application.getDepartmentId()).getName();
            String endTime = "";
            if (null != applicationResult.getEndTime()){
//                endTime = applicationResult.getEndTime().toString();
                SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                endTime=sDateFormat.format(applicationResult.getEndTime());
            } else {
                endTime = Constant.NO_INFO;
            }
            applicationResultVo.setOrganizationName(organizationName);
            applicationResultVo.setDepartmentName(departmentName);
            applicationResultVo.setEndTime(endTime);

            if (1 == application.getGender()){
                applicationResultVo.setGender("女");
            } else {
                applicationResultVo.setGender("男");
            }
            results.add(applicationResultVo);
        }
        return  results;
    }

    /**
     * 批量通过或拒绝报名
     * @param applicationIds
     * @param status
     * @param stageId
     * @return Result
     */
    @Override
    public Result applicationHandle(List<Integer> applicationIds, int status, int stageId) {
        Date dt = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        for (Integer id : applicationIds){
            applicationResultMapper.handleApplication(id, status, stageId, currentTime);
        }
        return Result.success();
    }

    /**
     * 搜索报名结果
     * @param condition
     * @param status
     * @param stageId
     * @return
     */
    @Override
    public Result searchResult(String condition, int status, int stageId) {
        List<Application> applications = applicationResultMapper.listSpecificApplication(status, stageId);
        List<ApplicationResultVo> applicationResultVos =  setProperties(applications);

        ApplicationResultVo selectedApplicationResult = new ApplicationResultVo();
        if (condition.contains(Constant.PREFIX_OF_STUDENT_ID)){
            //condition为学号形式
            for (ApplicationResultVo resultApplication : applicationResultVos){
                if (resultApplication.getStuId().equals(condition)){
                    //若找到匹配项
                    selectedApplicationResult = resultApplication;
                }
            }
        } else {
            //condition为姓名
            for (ApplicationResultVo resultApplication : applicationResultVos){
                    if (resultApplication.getStuName().equals(condition)){
                        selectedApplicationResult = resultApplication;
                    }
            }
        }
        if(selectedApplicationResult.getStuId() != null){
//            selectedApplicationResult.setEndTime(selectedApplicationResult.getEndTime().toString());

            return Result.success(selectedApplicationResult);
        }
        return Result.fail(Constant.NOT_FOUND);
    }

    /**
     * 添加报名结果
     * @param departmentId
     * @param stageId
     * @return
     */
    @Override
    public Result addResult(Integer departmentId, Integer stageId) {
        List<Application> applications = applicationService.listAll(departmentId);
        Integer result = 0;

        //为每一个报名表添加结果
        for (Application application : applications) {
            Integer resultEach = applicationResultMapper.addResult(application.getId(), stageId);
            result += resultEach;
        }
        if (result >= 1){
            return Result.success();
        }
        return Result.fail(Constant.FAILED);
    }
}
