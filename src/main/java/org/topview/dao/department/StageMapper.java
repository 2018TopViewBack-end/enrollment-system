package org.topview.dao.department;

import org.topview.dao.BaseMapper;
import org.topview.entity.application.po.Application;
import org.topview.entity.department.po.Stage;

import java.util.List;

public interface StageMapper extends BaseMapper<Stage, Integer> {

	/**
	 * 新增招新阶段
	 * @param stage
	 * @return
	 */
	int insert(Stage stage);

	/**
	 * 删除招新阶段
	 * @param stageId
	 * @return
	 */
	int deleteByPrimaryKey(Integer stageId);

	/**
	 * 通过部门id找到同一部门的所有招新阶段
	 * @param departmentId
	 * @return
	 */
	List<Stage> listStageByDepartmentId(Integer departmentId);

	/**
	 * 更改招新阶段名称
	 * @param stage
	 * @return
	 */
	int updateByPrimaryKey(Stage stage);

	/**
	 * 通过主键获取阶段
	 * @param stageId
	 * @return
	 */
	Stage selectByPrimaryKey(Integer stageId);
}
