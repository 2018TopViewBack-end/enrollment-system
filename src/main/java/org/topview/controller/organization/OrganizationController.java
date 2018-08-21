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
@CrossOrigin
@RequestMapping("/organization")
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
    @RequestMapping(value = "/selectOrganizationByStatus/{pageNum}/{status}")
    @ResponseBody
    public Result selectOrganizationByStatus(@PathVariable Integer pageNum, @PathVariable Integer status) {
        List<OrganizationBo> organizationList = organizationService.selectOrganizationService(pageNum, status);
        return Result.success(organizationList);
    }

    /**
     * 查询所有社团
     * @return Result对象，里面包含社团list
     */
    @RequestMapping(value = "/selectAllOrganization/{pageNum}")
    @ResponseBody
    public Result selectAllOrganization(@PathVariable Integer pageNum) {
        List<OrganizationBo> organizationList = organizationService.selectOrganizationService(pageNum);
        return Result.success(organizationList);
    }

    /**
     * 通过社团分类查询社团
     * @return Result对象，里面包含社团list
     */
    @RequestMapping(value = "/selectOrganizationByCategory/{pageNum}/{category}")
    @ResponseBody
    public Result selectOrganizationByCategory(@PathVariable Integer pageNum, @PathVariable String category) {
        List<OrganizationBo> organizationList = organizationService.selectOrganizationByCategoryService(pageNum,category);
        return Result.success(organizationList);
    }

    /**
     * 通过社团分类和状态查询社团
     * @param category
     * @param status
     * @return Result对象，里面包含社团list
     */
    @RequestMapping(value = "/selectOrganization/{pageNum}/{category}/{status}")
    @ResponseBody
    public Result selectOrganization(@PathVariable Integer pageNum, @PathVariable String category,
                                     @PathVariable Integer status) {
        List<OrganizationBo> organizationBoList = organizationService.selectOrganizationService(pageNum,category,status);
        return Result.success(organizationBoList);
    }

    /**
     * 通过社团的名字进行社团的模糊查询
     * @param name
     * @return
     */
    @RequestMapping(value = "/searchOrganization/{pageNum}/{name}")
    @ResponseBody
    public Result searchOrganization(@PathVariable Integer pageNum, @PathVariable String name) {
        List<OrganizationBo> organizationBoList = organizationService.selectOrganizationService(pageNum, name);
        return Result.success(organizationBoList);
    }

    /**
     * 更改社团的状态
     * @param organizationId
     * @param status 目标状态码
     * @return 更改的结果
     */
    @RequestMapping(value = "/updateOrganizationStatus/{status}/{organizationId}")
    @ResponseBody
    public Result updateOrganizationStatus(@PathVariable Integer status, @PathVariable Integer organizationId) {
        if(organizationService.updateOrganizationStatusService(status,organizationId) == 1) {
            return Result.success();
        } else {
            return Result.fail("更改失败，请稍后重试");
        }
    }
}
