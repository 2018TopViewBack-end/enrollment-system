package org.topview.service.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.dao.department.StageMapper;
import org.topview.entity.department.po.Stage;
import org.topview.util.Result;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class StageServiceImplTest {

	@Autowired
	private StageMapper stageMapper;

	/**
	 * 测试新增招新阶段
	 */
	@Test
	public void testAddStage() {
		Stage stage = new Stage();
		stage.setStageName("二轮");
		stage.setDepartmentId(1);
		System.out.println("插入前id："+stage.getId());
		stageMapper.insert(stage);
		System.out.println("插入后id："+stage.getId());
	}

	/**
	 * 测试删除阶段
	 */
	@Test
	public void testDeleteStage() {
		int stageId = 1;
		int flag = stageMapper.deleteByExample(stageId);
		System.out.println(flag);
	}

	/**
	 * 测试通过部门id找到同一部门的所有招新阶段
	 */
	@Test
	public void listAllStageByDepartmentId() {
		int departmentId = 1;
		List<Stage> stages = stageMapper.selectByExample(departmentId);
		System.out.println(stages);
	}
	/**
	 * 测试更改招新阶段名称
	 */
	@Test
	public  void updateStage() {
		Stage stage = new Stage();
		stage.setStageName("面试");
		stage.setId(6);
		int flag = stageMapper.updateByPrimaryKey(stage);
		System.out.println(flag);
	}

}
