package org.topview.controller.organization;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.DepartmentAdminVo;
import org.topview.service.organization.OrganizationService;
import org.topview.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    /**
     * 获取社团信息
     * @param organizationId 社团的id
     * @return 返回获取到的社团信息
     */
    @ResponseBody
    @RequestMapping(value = "/getOrganization", method = RequestMethod.POST)
    public Result getOrganization(@Param("organizationId") int organizationId) {
        return organizationService.getOrganization(organizationId);
    }

    /**
     * 修改社团信息
     * @param organization 要修改的社团对象
     * @return 返回修改的结果
     */
    @ResponseBody
    @RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
    public Result updateOrganization(Organization organization) {
        return organizationService.updateOrganization(organization);
    }

    /**
     * 添加部门管理员
     * @param departmentAdminVo 部门管理员对象
     * @return 返回修改的结果
     */
    @ResponseBody
    @RequestMapping(value = "/addDepartmentAdmin", method = RequestMethod.POST)
    public Result addDepartmentAdmin(@RequestBody DepartmentAdminVo departmentAdminVo) {
        return organizationService.addDepartmentAdmin(departmentAdminVo);
    }

    /**
     * 获取部门管理员信息
     * @param departmentId 部门id
     * @return 返回得到的结果
     */
    @ResponseBody
    @RequestMapping(value = "/getDepartmentAdmin", method = RequestMethod.POST)
    public Result getDepartmentAdmin(@Param("departmentId")int departmentId) {
        return organizationService.getDepartmentAdmin(departmentId);
    }

    /**
     * 修改管理员对象
     * @param user 部门管理员对象
     * @return 返回请求结果和描述信息
     */
    @ResponseBody
    @RequestMapping(value = "/updateDepartmentAdmin", method = RequestMethod.POST)
    public Result updateDepartmentAdmin(@RequestBody User user) {
        return organizationService.updateDepartmentAdmin(user);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDepartmentAdmin", method = RequestMethod.POST)
    public Result deleteDepartmentAdmin(@Param("departmentId")int departmentId) {
        return organizationService.deleteDepartmentAdmin(departmentId);
    }

    @ModelAttribute
    public void changeChar(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
    }

}
