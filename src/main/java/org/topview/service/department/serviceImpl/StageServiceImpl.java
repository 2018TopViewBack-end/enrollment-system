package org.topview.service.department.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.department.StageMapper;
import org.topview.entity.department.po.Stage;
import org.topview.service.department.StageService;
import org.topview.util.Result;

import java.util.List;

@Service
public class StageServiceImpl implements StageService {

	@Autowired
	private StageMapper stageMapper;


	/**
	 * 新增招新阶段
	 * @param stage
	 * @return
	 */
	@Override
	public Result addStage(Stage stage) {
		stageMapper.insert(stage);
		if (stage.getId() != 0) {
			return  Result.success(stage);
		} else {
			return  Result.fail("新增阶段失败");
		}
	}

	/**
	 * 删除招新阶段
	 * @param stageId
	 * @return
	 */
	@Override
	public Result deleteStage(int stageId) {
		int flag = stageMapper.deleteByExample(stageId);
		if (flag != 0) {
			return Result.success();
		} else {
			return Result.fail("删除失败");
		}
	}

	/**
	 * 通过部门id找到同一部门的所有招新阶段
	 * @param departmentId
	 * @return
	 */
	@Override
	public Result listAllStageByDepartmentId(int departmentId) {
		List<Stage> stages = stageMapper.selectByExample(departmentId);
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
			return Result.fail("修改招新阶段失败");
		}
	}



}
