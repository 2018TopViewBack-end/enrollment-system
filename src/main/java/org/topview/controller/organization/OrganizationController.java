package org.topview.controller.organization;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.bo.DepartmentAdminBo;
import org.topview.entity.organization.vo.OrganizationPhotoVo;
import org.topview.service.organization.OrganizationService;
import org.topview.util.Constant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.util.Md5Util;
import org.topview.util.Result;

import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * @author Pan梓涵
 */
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
    @PostMapping("/getOrganization")
    public Result getOrganization(@RequestParam Integer organizationId) {
        return organizationService.getOrganization(organizationId);
    }

    /**
     * 修改社团信息
     * @param organization 要修改的社团对象
     * @return 返回修改的结果
     */
    @ResponseBody
    @PostMapping("/updateOrganization")
    public Result updateOrganization(Organization organization) {
        return organizationService.updateOrganization(organization);
    }

    /**
     * 添加部门管理员
     * @param departmentAdminBo 部门管理员对象
     * @return 返回修改的结果
     */
    @ResponseBody
    @PostMapping("/addDepartmentAdmin")
    public Result addDepartmentAdmin(@RequestBody DepartmentAdminBo departmentAdminBo) {
        try {
            //为密码加盐
            User user = departmentAdminBo.getUser();
            user.setPassword(Md5Util.getMD5Password(user.getUsername(), user.getPassword()));
            return organizationService.addDepartmentAdmin(departmentAdminBo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("添加部门管理员数据失败,请重试");
        }
    }

    /**
     * 获取部门管理员信息
     * @param departmentId 部门id
     * @return 返回得到的结果
     */
    @ResponseBody
    @PostMapping("/getDepartmentAdmin")
    public Result getDepartmentAdmin(@RequestParam Integer departmentId) {
        return organizationService.getDepartmentAdmin(departmentId);
    }

    /**
     * 修改管理员对象
     * @param user 部门管理员对象
     * @return 返回请求结果和描述信息
     */
    @ResponseBody
    @PostMapping("/updateDepartmentAdmin")
    public Result updateDepartmentAdmin(@RequestBody User user, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        if(sessionUser != null) {
            user.setPassword(Md5Util.getMD5Password(sessionUser.getUsername(), user.getPassword()));
        }
        return organizationService.updateDepartmentAdmin(user);
    }

    /**
     * 删除管理员对象
     * @param departmentId 部门id
     * @return 返回修改结果
     */
    @ResponseBody
    @PostMapping("/deleteDepartmentAdmin")
    public Result deleteDepartmentAdmin(@RequestParam Integer departmentId) {
        return organizationService.deleteDepartmentAdmin(departmentId);
    }

    /**
     * 第一次获取首页的所有图片
     * @return 返回获取的结果
     */
    @ResponseBody
    @GetMapping("/getAllOrganizationPhotos")
    public Result getAllOrganizationPhotos() {
        return organizationService.getAllOrganizationPhoto();
    }

    /**
     * 根据社团类别和页码信息,获取下一组图片
     * @param pageNum 当前页
     * @param category 社团类别
     * @return 返回图片List
     */
    @ResponseBody
    @PostMapping("getOrganizationPhotosByCategory")
    public Result getOrganizationPhotosByCategory(@RequestParam("pageNum")Integer pageNum,
                                                  @RequestParam("category")String category) {
        PageInfo<OrganizationPhotoVo> pageInfo = organizationService.getOrganizationPhoto(pageNum,
                Constant.Page.PAGE_SIZE, category);
        if(pageInfo == null) {
            return Result.fail("请求图片失败");
        }
        return Result.success(pageInfo);
    }

    /**
     * 通过社团的状态查询社团
     * @return Result对象，里面包含社团list
     */
    @RequestMapping(value = "/selectOrganization/{status}")
    @ResponseBody
    public Result checkOrganization(@PathVariable Integer status) {
        List<OrganizationBo> organizationList = organizationService.selectOrganizationService(status);
        return Result.success(organizationList);
    }

    /**
     * 更改社团的状态
     * @param organizationStatus 里面包含userId，organizationId，目标status
     * @return 更改的结果
     */
    @RequestMapping(value = "/updateOrganizationStatus")
    @ResponseBody
    public Result updateOrganizationStatus(OrganizationStatus organizationStatus) {
        return null;
    }
}
