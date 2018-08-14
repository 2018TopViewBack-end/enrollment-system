package org.topview.service.department.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.application.ApplicationResultMapper;
import org.topview.dao.department.StageMapper;
import org.topview.entity.department.po.Stage;
import org.topview.service.department.StageService;
import org.topview.util.Constant;
import org.topview.util.Result;

import java.util.List;

@Service
public class StageServiceImpl implements StageService {

	@Autowired
	private StageMapper stageMapper;

	@Autowired
	private ApplicationResultMapper applicationResultMapper;
	/**
	 * 新增招新阶段
	 * @param stage
	 * @return
	 */
	@Override
	public Result addStage(Stage stage) {
		int lastStageId = stage.getId();
		if (lastStageId != 0) {
			List<Integer> applicationId = applicationResultMapper.listSpecificAppId(0, lastStageId);
			if (applicationId.size() != 0) {
				return Result.fail(Constant.CAN_NOT_ADD_STAGE);
			}
		}
		stageMapper.insert(stage);
		if (stage.getId() != 0) {
			return  Result.success(stage);
		} else {
			return  Result.fail(Constant.ADD_FAIL);
		}
	}

	/**
	 * 删除招新阶段
	 * @param stageId
	 * @return
	 */
	@Override
	public Result deleteStage(int stageId) {
		int flag = stageMapper.deleteByPrimaryKey(stageId);
		if (flag != 0) {
			return Result.success();
		} else {
			return Result.fail(Constant.FAIL_TO_DELETE);
		}
	}

	/**
	 * 通过部门id找到同一部门的所有招新阶段
	 * @param departmentId
	 * @return
	 */
	@Override
	public Result listAllStageByDepartmentId(int departmentId) {
		List<Stage> stages = stageMapper.listStageByDepartmentId(departmentId);
		if (stages != null) {
			return Result.success(stages);
		} else {
			return null;
		}
	}

	/**
	 * 更改招新阶段名称
	 * @param stage
	 * @return
	 */
	@Override
	public Result updateStage(Stage stage) {
		int flag = stageMapper.updateByPrimaryKey(stage);
		if (flag != 0) {
			return Result.success();
		} else {
			return Result.fail(Constant.MODIFY_STAGE_FAIL);
		}
	}
}
