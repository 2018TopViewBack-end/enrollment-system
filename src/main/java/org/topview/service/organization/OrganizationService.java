package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.entity.organization.bo.Organization;

import java.util.List;

@Service
public interface OrganizationService {

    List<Organization> selectOrganizationService(Integer status);
}
