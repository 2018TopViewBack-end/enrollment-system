package org.topview.dao.organization;

import org.apache.ibatis.annotations.Param;
import org.topview.dao.BaseMapper;
import org.topview.entity.organization.bo.Organization;

import java.util.List;

public interface OrganizationMapper extends BaseMapper<Organization, Integer> {

    /**
     * 查询该状态下的所有社团
     * @param status 状态
     * @return 该状态下的社团list
     */
    List<Organization> selectOrganizationByStatus(Integer status);

    /**
     * 更新社团的状态
     * @param id 社团id
     * @param status 社团新的状态
     * @return 更新成功返回1，否则返回0
     */
    Integer updateOrganizationStatus(@Param("status") Integer status, @Param("id") Integer id);
}
