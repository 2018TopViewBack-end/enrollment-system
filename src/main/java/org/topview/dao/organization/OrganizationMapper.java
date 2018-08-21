package org.topview.dao.organization;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.topview.dao.BaseMapper;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.vo.OrganizationPhotoVo;

import java.util.List;

@Repository
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
     * 添加社团
     * @param organization 社团
     * @return 增加的条数
     */
    @Override
    int insert(Organization organization);

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
