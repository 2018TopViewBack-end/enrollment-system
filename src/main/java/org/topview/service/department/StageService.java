package org.topview.service.department;

import org.springframework.stereotype.Service;
import org.topview.entity.department.po.Stage;
import org.topview.util.Result;

@Service
public interface StageService {

	/**
	 * 新增招新阶段
	 * @param stage
	 * @return
	 */
	Result addStage(Stage stage);

	/**
	 * 删除招新阶段
	 * @param stageId
	 * @return
	 */
	Result deleteStage(int stageId);

	/**
	 * 通过部门id找到同一部门的所有招新阶段
	 * @param departmentId
	 * @return
	 */
	Result listAllStageByDepartmentId(int departmentId);

	/**
	 * 更改招新阶段名称
	 * @param stage
	 * @return
	 */
	Result updateStage(Stage stage);

}
