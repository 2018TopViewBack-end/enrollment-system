package org.topview.controller.organization;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.service.organization.OrganizationService;
import org.topview.util.Result;

import java.io.Serializable;
import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
    @ResponseBody
    public Result updateOrganization() {
        return null;
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
