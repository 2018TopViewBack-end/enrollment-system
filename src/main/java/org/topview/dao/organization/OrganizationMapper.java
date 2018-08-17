package org.topview.dao.organization;

import org.apache.ibatis.annotations.Param;
import org.topview.dao.BaseMapper;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.po.User;
import org.topview.entity.organization.vo.OrganizationPhotoVo;

import java.util.List;

public interface OrganizationMapper extends BaseMapper<Organization, Integer> {

    /**
     * 根据社团管理员id,获取社团id
     * @param adminId 社团管理员id
     * @return 返回社团id
     */
    Integer getOrganizationIdByAdminId(Integer adminId);

    /**
     * 根据社团id,获取社团当前的状态
     * @param id 社团id
     * @return 返回社团当前的状态
     */
    Integer getOrganizationStatusById(Integer id);

    /**
     * 查询该状态下的所有社团
     * @param status 状态
     * @return 该状态下的社团list
     */
    List<OrganizationBo> selectOrganizationByStatus(Integer status);

    /**
     * 根据类别获取社团图片列表
     * @param category 社团类别
     * @return 返回查询结果集
     */
    List<OrganizationPhotoVo> getOrganizationPhotosByCategory(String category);

    /**
     * 更新社团的状态
     * @param id 社团id
     * @param status 社团新的状态
     * @return 更新成功返回1，否则返回0
     */
    Integer updateOrganizationStatus(@Param("status") Integer status, @Param("id") Integer id);

    /**
     * 添加社团
     * @param organization 社团
     * @return 增加的条数
     */
    @Override
    int insert(Organization organization);
}
