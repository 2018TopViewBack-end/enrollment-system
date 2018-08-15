package org.topview.controller.department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.topview.entity.department.po.Stage;
import org.topview.service.department.StageService;
import org.topview.util.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration("src/main/resources")
public class StageControllerTest {

	@Autowired
	private StageService stageService;

	/**
	 * 测试新增招新阶段
	 */
	@Test
	public void testAddStage() {
		Stage stage = new Stage();
		stage.setStageName("三轮");
		stage.setDepartmentId(1);
		stage.setId(20);
		System.out.println("插入前id：" + stage.getId());
		Result result = stageService.addStage(stage);
		System.out.println("插入后id：" + stage.getId() + " " + result.getMsg());
	}

	/**
	 * 测试删除阶段
	 */
	@Test
	public void testDeleteStage() {
		int stageId = 5;
		Result result = stageService.deleteStage(stageId);
		System.out.println(result.getMsg());
	}

	/**
	 * 测试通过部门id找到同一部门的所有招新阶段
	 */
	@Test
	public void listAllStageByDepartmentId() {
		int departmentId = 1;
		Result result = stageService.listAllStageByDepartmentId(departmentId);
		System.out.println(result.getData());
	}

	/**
	 * 测试更改招新阶段名称
	 */
	@Test
	public void updateStage() {
		Stage stage = new Stage();
		stage.setStageName("面试");
		stage.setId(6);
		Result result = stageService.updateStage(stage);
		System.out.println(result.getMsg());
	}
}