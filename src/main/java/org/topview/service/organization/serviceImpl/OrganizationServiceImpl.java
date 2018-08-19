package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.service.organization.OrganizationService;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    /**
     * 查询该状态下的所有社团
     * @param status 状态码 0为待审核，1为可用，2为禁用
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum, Integer status) {
        return organizationMapper.selectOrganizationByStatus(status);
    }

    /**
     * 通过名字模糊查询社团
     * @param name
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum, String name) {
        name = '%'+name+'%';
        return organizationMapper.selectOrganizationByName(name);
    }

    /**
     * 通过社团分类查询社团
     * @param category
     * @return
     */
    @Override
    public List<OrganizationBo> selectOrganizationByCategoryService(Integer pageNum, String category) {
        return organizationMapper.selectOrganizationByCategory(category);
    }

    /**
     * 查询所有社团
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum) {
        return organizationMapper.selectAllOrganization();
    }

    /**
     * 通过社团分类和状态查询社团
     * @param category
     * @param status
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer pageNum, String category, Integer status) {
        return organizationMapper.selectOrganization(category,status);
    }

    @Override
    public Integer getOrganizationIdByAdminId(Integer adminId) {
        return 0;
    }

    /**
     * 将社团的状态改为目标状态
     * @param status 目标状态码
     * @param organizationId 社团id
     * @return 修改成功返回1,
     */
    @Override
    public Integer updateOrganizationStatusService(Integer status, Integer organizationId) {
        return organizationMapper.updateOrganizationStatus(status,organizationId);
    }
}
