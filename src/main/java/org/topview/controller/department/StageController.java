package org.topview.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.department.po.Stage;
import org.topview.service.department.StageService;
import org.topview.util.Result;

@Controller
@RequestMapping("/department/stage")
public class StageController {

	@Autowired
	private StageService stageService;

	/**
	 * 新增招新阶段
	 * @param stage
	 * @return
	 */
	@RequestMapping("/addStage")
	@ResponseBody
	public Result addStage(Stage stage) {
		return stageService.addStage(stage);
	}

	/**
	 * 删除招新阶段
	 * @param stageId
	 * @return
	 */
	@RequestMapping("/deleteStage")
	@ResponseBody
	public Result deleteStage(@RequestParam("stageId") Integer  stageId) {
		return stageService.deleteStage(stageId);
	}

	/**
	 * 通过部门id找到同一部门的所有招新阶段
	 * @param departmentId
	 * @return
	 */
	@RequestMapping("/listAllStageByDepartmentId")
	@ResponseBody
	public Result listAllStageByDepartmentId(@RequestParam("departmentId") Integer  departmentId) {
		return stageService.listAllStageByDepartmentId(departmentId);
	}

	/**
	 * 更改招新阶段名称
	 * @param stage
	 * @return
	 */
	@RequestMapping("/updateStage")
	@ResponseBody
	public Result updateStage(Stage stage) {
		return stageService.updateStage(stage);
	}


}
