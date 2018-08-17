package org.topview.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.department.bo.DepartmentBo;
import org.topview.entity.department.po.Department;
import org.topview.entity.department.po.SMS;
import org.topview.service.department.DepartmentService;
import org.topview.util.ImgUtil;
import org.topview.util.Result;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

    /**
	 * 保存部门信息
     * @param file  文件对象
     * @param department  要保存的部门对象
     * @return Result
     */
    @RequestMapping("/saveDepartment")
    @ResponseBody
    public Result saveDepartment(HttpServletRequest request, @RequestParam(value = "file",required = false) MultipartFile file, Department department) {
        //接收返回的要保存到数据库的路径
        String filePath = ImgUtil.savePicture(request, file);
        department.setLogoUrl(filePath);
       	return departmentService.addDepartment(department);
    }
	/**
	 * 修改部门信息
	 * @param departmentBo
	 * @return
	 */
	@RequestMapping("/updateDepartment")
	@ResponseBody
	public Result updateDepartment(HttpServletRequest request, @RequestParam(value = "file",required = false) MultipartFile file, DepartmentBo departmentBo) {
		//接收返回的要保存到数据库的路径
		String filePath = ImgUtil.savePicture(request, file);
		departmentBo.setLogoUrl(filePath);
		return departmentService.updateDepartment(departmentBo);
	}


	/**
	 * 得到同一社团所有部门
	 * @param organizationId
	 * @return
	 */
	@RequestMapping("/getOrganizationDepartment")
	@ResponseBody
	public Result getOrganizationDepartment(int organizationId) {
		return departmentService.listDepartmentByOrganizationId(organizationId);
	}

	/**
	 * 得到正在允许报名的部门
	 * @param organizationId
	 * @return
	 */
	@RequestMapping("/getSigningDepartment")
	@ResponseBody
	public Result getSigningDepartment(int organizationId) {
		return departmentService.getSigningDepartment(organizationId);
	}

	/**
	 * 记录部门使用的短信数量
	 * @param id 部门id
	 * @param messageNum  部门使用的短信数量
	 * @return 是否成功
	 */
	@RequestMapping("/updateDepartmentMessageNum")
	@ResponseBody
	public Result updateDepartmentMessageNum( int id, int messageNum){
		return departmentService.updateDepartmentMessageNum(id,messageNum);
	}

	/**
	 * 查出部门信息
	 * @param id 部门id
	 * @return 部门信息与是否成功
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Result findById(Integer id){
		return departmentService.findById(id);
	}
}