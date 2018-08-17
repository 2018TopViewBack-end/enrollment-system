package org.topview.dao.department;

import org.topview.dao.BaseMapper;
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
	int deleteByExample(int stageId);

	/**
	 * 通过部门id找到同一部门的所有招新阶段
	 * @param departmentId
	 * @return
	 */
	List<Stage> selectByExample(int departmentId);

	/**
	 * 更改招新阶段名称
	 * @param stage
	 * @return
	 */
	int updateByPrimaryKey(Stage stage);
}
