package org.topview.controller.organization;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.OrganizationService;
import org.topview.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author Pan梓涵
 */
import java.util.List;

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
    public Result getOrganization(@Param("organizationId") Integer organizationId) {
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
     * @param departmentAdminBo 部门管理员对象
     * @return 返回修改的结果
     */
    @ResponseBody
    @RequestMapping(value = "/addDepartmentAdmin", method = RequestMethod.POST)
    public Result addDepartmentAdmin(@RequestBody DepartmentAdminBo departmentAdminBo) {
        return organizationService.addDepartmentAdmin(departmentAdminBo);
    }

    /**
     * 获取部门管理员信息
     * @param departmentId 部门id
     * @return 返回得到的结果
     */
    @ResponseBody
    @RequestMapping(value = "/getDepartmentAdmin", method = RequestMethod.POST)
    public Result getDepartmentAdmin(@Param("departmentId")Integer departmentId) {
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

    /**
     * 删除管理员对象
     * @param departmentId 部门id
     * @return 返回修改结果
     */
    @ResponseBody
    @RequestMapping(value = "/deleteDepartmentAdmin", method = RequestMethod.POST)
    public Result deleteDepartmentAdmin(@Param("departmentId")Integer departmentId) {
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

    @ModelAttribute
    public void changeChar(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
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
