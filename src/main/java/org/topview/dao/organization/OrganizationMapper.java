package org.topview.dao.organization;

import org.topview.dao.BaseMapper;
import org.topview.entity.organization.po.Organization;
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
     * 根据类别获取社团图片列表
     * @param category 社团类别
     * @return 返回查询结果集
     */
    List<OrganizationPhotoVo> getOrganizationPhotosByCategory(String category);
}
