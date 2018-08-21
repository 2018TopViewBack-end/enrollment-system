package org.topview.controller.application;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.entity.application.po.Application;
import org.topview.service.application.ApplicationResultService;
import org.topview.service.application.ApplicationService;
import org.topview.util.Constant;
import org.topview.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 报名表Controller
 * @author Medwin。
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    ApplicationResultService applicationResultService;

    /**
     * 获取对应状态报名列表
     * @param status 报名状态
     * @param stageId 阶段id
     * @return result
     */
    @ResponseBody
    @GetMapping("get")
    Result getPassedApplications(@RequestBody int pageNum, @RequestBody int pageSize, @RequestBody int status,
                                 @RequestBody int stageId, HttpServletRequest request){
        PageInfo<Application> applicationPageInfo = applicationService.listApplicationOf(pageNum, pageSize, status, stageId);
        request.setAttribute("stageId",stageId);
        if (null != applicationPageInfo){
            return Result.success(applicationPageInfo);
        } else {
            return Result.fail(Constant.NOT_FOUND);
        }
    }

    /**
     * 查看报名结果
     * @param tel 电话号码
     * @param studentId 学号
     * @return result
     */
    @ResponseBody
    @PostMapping("check")
    Result check(@RequestParam String tel, @RequestParam String studentId){
        return applicationResultService.checkResult(tel, studentId);
    }

    /**
     * 批量处理报名
     * @param applicationIds 报名表id集
     * @param status 要设置的报名状态
     * @return
     */
    @ResponseBody
    @PostMapping("handle")
    Result handle(@RequestBody List<Integer> applicationIds, @RequestBody int status, @RequestBody int stageId){
        return applicationResultService.applicationHandle(applicationIds, status, stageId);
    }

    /**
     * 添加报名表
     * @param application 报名表
     * @return 是否成功结果
     */
    @ResponseBody
    @PostMapping("add")
    Result add(@RequestBody Application application){
        return applicationService.addApplication(application);
    }

//      //查看是否有未审核报名
//    @ResponseBody
//    @GetMapping("check/result/")
//    Result checkPass(@PathVariable int stageId){
//        if (applicationService.checkApplicationToPass(stageId)){
//            return Result.success();
//        } else {
//            return Result.fail(Constant.NOT_FOUND);
//        }
//    }
}
