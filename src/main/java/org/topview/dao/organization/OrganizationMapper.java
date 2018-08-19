package org.topview.dao.organization;

import org.apache.ibatis.annotations.Param;
import org.topview.dao.BaseMapper;
import org.topview.entity.organization.bo.OrganizationBo;

import java.util.ArrayList;
import java.util.List;

public interface OrganizationMapper extends BaseMapper<OrganizationBo, Integer> {

    /**
     * 查询该状态下的所有社团
     * @param status 状态
     * @return 该状态下的社团list
     */
    List<OrganizationBo> selectOrganizationByStatus(Integer status);

    /**
     * 查询所有社团
     * @return 社团list
     */
    List<OrganizationBo> selectAllOrganization();

    /**
     * 通过名字进行社团的模糊查询
     * @param name
     * @return
     */
    List<OrganizationBo> selectOrganizationByName(String name);

    /**
     * 更新社团的状态
     * @param id 社团id
     * @param status 社团新的状态
     * @return 更新成功返回1，否则返回0
     */
    Integer updateOrganizationStatus(@Param("status") Integer status, @Param("id") Integer id);

    /**
     * 同意社团申请时，向社团表中加入apiKey
     * @param apiKey 发送短信用的apiKey
     * @param id 社团id
     * @return
     */
    Integer addApiKey(@Param("apiKey") String apiKey,@Param("id") Integer id);

    /**
     * 分类筛选社团
     * @param category
     * @return
     */
    List<OrganizationBo> selectOrganizationByCategory(String category);

    /**
     * 通过社团类别和状态筛选社团
     * @param category
     * @param status
     * @return
     */
    List<OrganizationBo> selectOrganization(@Param("category") String category,@Param("status") Integer status);
}
