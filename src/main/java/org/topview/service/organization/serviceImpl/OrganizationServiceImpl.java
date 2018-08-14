package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.dao.organization.UserMapper;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.vo.OrganizationStatus;
import org.topview.service.organization.OrganizationService;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    /**
     * 返回该状态下的所有社团
     * @param status 状态码 0为待审核，1为可用，2为禁用
     * @return 一个社团list
     */
    @Override
    public List<OrganizationBo> selectOrganizationService(Integer status) {
        return organizationMapper.selectOrganizationByStatus(status);
    }

}
