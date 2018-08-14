package org.topview.service.application.serviceImpl;


import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.topview.dao.application.ApplicationMapper;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.dao.department.DepartmentMapper;
import org.topview.dao.department.StageMapper;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.entity.application.po.Application;
import org.topview.entity.application.po.ApplicationResult;
import org.topview.entity.application.vo.ApplicationResultVo;
import org.topview.entity.department.po.Department;
import org.topview.entity.organization.po.Organization;
import org.topview.service.application.ApplicationResultService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.ArrayList;
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

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private StageMapper stageMapper;

    @Override
    public Result checkResult(String tel, int studentId) {
        //取得该学生所有申请
        List<Application> applications = applicationMapper.getApplication(tel, studentId);
        List<ApplicationResultVo> results = new ArrayList<>();

        for (Application application: applications){
            //遍历该学生每一张报名表
            int departmentId = application.getDepartmentId();
//            int newestStageId = departmentMapper.getNewestStageByDepartmentId(departmentId);
            //获取最新一轮结果
            int newestStageId = applicationResultMapper.selectMaxStageId(application.getId());
            ApplicationResult applicationResult = applicationResultMapper.checkResult(application.getId());

            if (newestStageId == applicationResult.getStageId()){
                ApplicationResultVo applicationResultVo= new ApplicationResultVo();
                //复制和设置vo字段值
                BeanUtils.copyProperties(application,applicationResultVo);
                BeanUtils.copyProperties(applicationResult,applicationResultVo);

                applicationResultVo.setOrganizationName(organizationMapper.selectByPrimaryKey(application.getOrganizationId()).getName());
                applicationResultVo.setDepartmentName(departmentMapper.selectByPrimaryKey(application.getDepartmentId()).getName());
                String stageName = stageMapper.selectByPrimaryKey(applicationResult.getStageId()).getStageName();
                applicationResultVo.setStage(stageName);

                if (0 == applicationResult.getStatus()){
                    applicationResultVo.setResult(Constant.TO_BE_DECIDED);
                } else if (1 == applicationResult.getStatus()){
                    applicationResultVo.setResult(Constant.SUBMIT_SUCCEED);
                } else {
                    applicationResultVo.setResult(Constant.SUBMIT_FAILED);
                }
                results.add(applicationResultVo);
            }
        }
        return Result.success(results);
    }

    @Override
    public void applicationHandle(List<Integer> applicationIds, int status) {
        for (Integer id : applicationIds){
            applicationResultMapper.handleApplication(id,status);
        }
    }
}
