package org.topview.service.organization;

import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    /**
     * 根据社团管理员id获取社团信息
     * @param adminId 社团管理员的id
     * @return 社团信息id
     */
    Integer getOrganizationIdByAdminId(Integer adminId);
}
