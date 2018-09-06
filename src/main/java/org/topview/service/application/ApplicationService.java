package org.topview.service.application;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.topview.entity.application.po.Application;
import org.topview.util.Result;

import java.util.List;

@Service
public interface ApplicationService {

    Result addApplication(Application application); //添加报名表

    boolean checkApplication(String studentId , int departmentId); //检查是否已经报名

    PageInfo<Application> listApplicationOf(int pageNum, int pageSize, int status, int stageId);   //选出特定阶段和部门的报名表

    Result listAll(int pageNum, int pageSize, Integer departmentId);//当部门未截止报名时，列出该部门所有报名表

    List<Application> listAll(Integer departmentId);//不分页列出该部门所有报名表

//    //查看是否还有上一轮未审核的报名，若有，则无法开启下一轮
//    boolean checkApplicationToPass(int stageId);
}
