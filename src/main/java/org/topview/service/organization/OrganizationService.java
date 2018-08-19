package org.topview.service.organization;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.po.Organization;
import org.topview.entity.organization.vo.OrganizationStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public interface OrganizationService {


    /**
     * 根据社团管理员id获取社团信息
     * @param adminId 社团管理员的id
     * @return 社团信息id
     */
    Integer getOrganizationIdByAdminId(Integer adminId);

    List<OrganizationBo> selectOrganizationService(Integer pageNum,Integer status);

    List<OrganizationBo> selectOrganizationService(Integer pageNum, String name);

    List<OrganizationBo> selectOrganizationByCategoryService(Integer pageNum, String category);

    List<OrganizationBo> selectOrganizationService(Integer pageNum);

    List<OrganizationBo> selectOrganizationService(Integer pageNum, String category, Integer status);

    Integer updateOrganizationStatusService(Integer status, Integer organizationId);

}
