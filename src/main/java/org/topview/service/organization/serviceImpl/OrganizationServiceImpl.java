package org.topview.service.organization.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.OrganizationMapper;
import org.topview.entity.organization.bo.Organization;
import org.topview.service.organization.OrganizationService;

import java.util.List;
import org.topview.service.organization.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper mapper;

    @Override
    public List<Organization> selectOrganizationService(Integer status) {
        return mapper.selectOrganizationByStatus(status);
    }
    @Override
    public Integer getOrganizationIdByAdminId(Integer adminId) {
        return 0;
    }
}
