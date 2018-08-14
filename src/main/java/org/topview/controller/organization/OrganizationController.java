package org.topview.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.OrganizationService;
import org.topview.util.Result;

import java.util.List;

@Controller
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
