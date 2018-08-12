package org.topview.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.topview.dao.organization.OrganizationMapper;

@Service
public class OrganizationServiceImpl {

    @Autowired
    private OrganizationMapper organizationMapper;



}
