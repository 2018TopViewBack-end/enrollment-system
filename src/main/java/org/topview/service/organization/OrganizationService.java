package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.DepartmentAdminVo;
import org.topview.util.Result;

/**
 * @author Pan梓涵
 */
@Service
public interface OrganizationService {

    /**
     * 更新社团信息
     * @param organization 社团信息对象
     * @return 结果集(包含是否操作成功,以及描述信息)
     */
    Result updateOrganization(Organization organization);

    /**
     * 获取社团信息
     * @param organizationId 社团信息
     * @return 获取社团信息
     */
    Result getOrganization(Integer organizationId);

    /**
     * 添加部门管理员
     * @param departmentAdminVo 部门管理员vo对象
     * @return 结果集(包含是否操作成功,以及描述信息)
     */
    Result addDepartmentAdmin(DepartmentAdminVo departmentAdminVo);

    /**
     * 获取部门管理员的信息
     * @param departmentId 部门的id
     * @return 结果集(包含是否操作成功,描述信息,请求结果)
     */
    Result getDepartmentAdmin(Integer departmentId);

    /**
     * 修改部门管理员的信息
     * @param user 部门管理员对象
     * @return 结果集(包含是否操作成功,描述信息)
     */
    Result updateDepartmentAdmin(User user);

    /**
     * 删除部门管理员的信息
     * @param departmentId 部门id
     * @return 结果集(包含是否操作成功,描述信息)
     */
    Result deleteDepartmentAdmin(Integer departmentId);

    /**
     * 根据社团管理员id获取社团信息
     * @param adminId 社团管理员的id
     * @return 社团信息id,查询不到返回null
     */
    Integer getOrganizationIdByAdminId(Integer adminId);

}
