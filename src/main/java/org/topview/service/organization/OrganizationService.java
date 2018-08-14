package org.topview.service.organization;

import org.springframework.stereotype.Service;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.entity.organization.vo.OrganizationStatus;

import java.util.List;

@Service
public interface OrganizationService {

    List<OrganizationBo> selectOrganizationService(Integer status);

}
