package org.topview.controller.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.service.application.ApplicationResultService;
import org.topview.service.application.ApplicationService;
import org.topview.util.Constant;
import org.topview.util.Result;

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
    @GetMapping("get/{status}/{stageId}")
    Result getPassedApplications(@PathVariable int status, @PathVariable int stageId){
        if (null != applicationService.listApplicationOf(status, stageId)){
            return Result.success(applicationService.listApplicationOf(status, stageId));
        } else {
            return Result.fail(Constant.NOT_FOUND);
        }
    }

    /**
     *
     * @param tel
     * @param studentId
     * @return result
     */
    @ResponseBody
    @PostMapping("check")
    Result check(@RequestParam String tel, @RequestParam int studentId){
        return applicationResultService.checkResult(tel, studentId);
    }
//
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
