package org.topview.service.organization;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.bo.DepartmentAdminBo;
import org.topview.entity.organization.vo.OrganizationPhotoVo;
import org.topview.util.Result;

import java.util.List;

/**
 * @author Pan梓涵
 */
@Service
public interface OrganizationService {

    /**
     * 更新社团信息
     *
     * @param organization 社团信息对象
     * @return 结果集(包含是否操作成功, 以及描述信息)
     */
    Result updateOrganization(Organization organization);

    /**
     * 获取社团信息
     *
     * @param organizationId 社团信息
     * @return 获取社团信息
     */
    Result getOrganization(Integer organizationId);

    /**
     * 添加部门管理员
     *
     * @param departmentAdminBo 部门管理员vo对象
     * @return 结果集(包含是否操作成功, 以及描述信息)
     */
    Result addDepartmentAdmin(DepartmentAdminBo departmentAdminBo) throws Exception;

    /**
     * 获取部门管理员的信息
     * @param departmentId 部门的id
     * @return 结果集(包含是否操作成功, 描述信息, 请求结果)
     */
    Result getDepartmentAdmin(Integer departmentId);

    /**
     * 修改部门管理员的信息
     *
     * @param user 部门管理员对象
     * @return 结果集(包含是否操作成功, 描述信息)
     */
    Result updateDepartmentAdmin(User user);

    /**
     * 删除部门管理员的信息
     *
     * @param departmentId 部门id
     * @return 结果集(包含是否操作成功, 描述信息)
     */
    Result deleteDepartmentAdmin(Integer departmentId);

    /**
     * 根据社团管理员id获取社团信息
     *
     * @param adminId 社团管理员的id
     * @return 社团信息id, 查询不到返回null
     */
    Integer getOrganizationIdByAdminId(Integer adminId);


    /**
     * 获取首页的社团图片
     * @return 返回获取的结果
     */
    Result getAllOrganizationPhoto();

    /**
     * 首页社团获取一组图片
     * @param pageNum 当前页
     * @param pageSize 每页大小
     * @param category 社团类别
     * @return 获取的结果集
     */
    PageInfo<OrganizationPhotoVo> getOrganizationPhoto(int pageNum, int pageSize, String category);

    /**
     * 通过状态查询社团（超级管理员）
     * @param pageNum
     * @param status
     * @return
     */
    List<OrganizationBo> selectOrganizationService(Integer pageNum,Integer status);

    /**
     * 通过姓名模糊查询社团（超级管理员）
     * @param pageNum
     * @param name
     * @return
     */
    List<OrganizationBo> selectOrganizationService(Integer pageNum, String name);

    /**
     * 通过社团类别查询社团（超级管理员）
     * @param pageNum
     * @param category
     * @return
     */
    List<OrganizationBo> selectOrganizationByCategoryService(Integer pageNum, String category);

    /**
     * 查询所有社团（超级管理员）
     * @param pageNum
     * @return
     */
    List<OrganizationBo> selectOrganizationService(Integer pageNum);

    /**
     * 通过分类和状态查询社团（超级管理员）
     * @param pageNum
     * @param category
     * @param status
     * @return
     */
    List<OrganizationBo> selectOrganizationService(Integer pageNum, String category, Integer status);

    /**
     * 更新社团User的状态（超级管理员）
     * @param status
     * @param organizationId
     * @return
     */
    Integer updateOrganizationStatusService(Integer status, Integer organizationId);

}